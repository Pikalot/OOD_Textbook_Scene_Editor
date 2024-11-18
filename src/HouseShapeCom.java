import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class HouseShapeCom extends CompoundShape {
    public HouseShapeCom(double x, double y, double width) {
        Rectangle2D base = new Rectangle2D.Double(x, y + width/2, width, width);
        Line2D leftRoof = new Line2D.Double(x, y + width/2, x + width/2, y);
        Line2D rightRoof = new Line2D.Double(x + width/2, y, x + width, y + width/2);

        this.addShape(base);
        this.addShape(leftRoof);
        this.addShape(rightRoof);
    }
}
