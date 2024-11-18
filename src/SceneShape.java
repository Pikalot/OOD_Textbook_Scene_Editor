import java.awt.*;
import java.awt.geom.Point2D;

public interface SceneShape {
    boolean isSelected();
    void setSelected(boolean s);
    void draw(Graphics2D g);
    void drawSelection(Graphics2D g);
    void translate(double dx, double dy);
    boolean contains(Point2D p);
}