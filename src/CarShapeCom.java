import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class CarShape extends SelectableShape {
    private double x;
    private double y;
    private double width;

    public CarShape(double x, double y, double width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    @Override
    public void draw(Graphics2D g) {
        Rectangle2D cockpit = new Rectangle2D.Double(x + width/4, y, width/2, width/6);
        Rectangle2D body = new Rectangle2D.Double(x, y + width/6, width, width/6);
        Ellipse2D rearWheel = new Ellipse2D.Double(x + width/4, y + width/3, width/8, width/8);
        Ellipse2D frontWheel = new Ellipse2D.Double(x + width * 3/4, y + width/3, width/8, width/8);
        Line2D windShield = new Line2D.Double(x + width * 3/4, y, x + width, y + width/6);

        g.draw(cockpit);
        g.draw(body);
        g.draw(rearWheel);
        g.draw(frontWheel);
        g.draw(windShield);
    }

/*    @Override
    public void drawSelection(Graphics2D g) {
        if (this.isSelected()) {
            Rectangle2D body = new Rectangle2D.Double(x, y + width/6, width, width/6);
            g.fill(body);
        }
    }*/

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean contains(Point2D p) {
        return x <= p.getX() && p.getX() <= x + width && y <= p.getY() && p.getY() <= y + width/2;
    }
}

