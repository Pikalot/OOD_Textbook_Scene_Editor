import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class HouseShape extends SelectableShape {
    private double x;
    private double y;
    private double width;

    public HouseShape(double x, double y, double width) {
        this.x = x;
        this.y = y;
        this.width = width;
    }

    @Override
    public void draw(Graphics2D g) {
        Rectangle2D base = new Rectangle2D.Double(x, y + width/2, width, width);
        Line2D leftRoof = new Line2D.Double(x, y + width/2, x + width/2, y);
        Line2D rightRoof = new Line2D.Double(x + width/2, y, x + width, y + width/2);

        g.draw(base);
        g.draw(leftRoof);
        g.draw(rightRoof);
    }

/*    @Override
    public void drawSelection(Graphics2D g) {
        Rectangle2D base = new Rectangle2D.Double(x, y + width/2, width, width);
        g.fill(base);
    }*/

    @Override
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    @Override
    public boolean contains(Point2D p) {
        return x <= p.getX() && p.getX() <= x + width && y <= p.getY() && p.getY() <= y + width * 3/2;
    }
}