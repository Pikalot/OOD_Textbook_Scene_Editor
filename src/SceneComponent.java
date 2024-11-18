import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class SceneComponent extends JComponent {
    ArrayList<SceneShape> shapes;
    Point2D mousePoint;

    public SceneComponent() {
        shapes = new ArrayList<>();
        this.addMouseListener(new MousePressedListener());
        this.addMouseMotionListener(new MouseDraggedListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (SceneShape s: shapes) {
            s.draw(g2);
            if (s.isSelected()) s.drawSelection(g2);
        }
    }

    public void addShape(SceneShape s) {
        shapes.add(s);
        repaint();
    }

    public void removeSelection() {
        for (int i = shapes.size() - 1; i >= 0; i--) {
            if (shapes.get(i).isSelected()) shapes.remove(i);
        }
        repaint();
    }

    private class MousePressedListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            mousePoint = event.getPoint();
            for (SceneShape s: shapes) {
                if (s.contains(mousePoint)) s.setSelected(!s.isSelected());
            }
            repaint();
        }
    }

    private class MouseDraggedListener extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent event) {
            Point2D lastPoint = mousePoint;
            mousePoint = event.getPoint();
            for (SceneShape s: shapes) {
                if (s.isSelected()) {
                    double dx = mousePoint.getX() - lastPoint.getX();
                    double dy = mousePoint.getY() - lastPoint.getY();
                    s.translate(dx, dy);
                }
            }
            repaint();
        }
    }
}