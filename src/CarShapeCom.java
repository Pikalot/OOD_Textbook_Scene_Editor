import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class CarShapeCom extends CompoundShape {


    public CarShapeCom(double x, double y, double width) {
        Rectangle2D cockpit = new Rectangle2D.Double(x + width/4, y, width/2, width/6);
        Rectangle2D body = new Rectangle2D.Double(x, y + width/6, width, width/6);
        Ellipse2D rearWheel = new Ellipse2D.Double(x + width/4, y + width/3, width/8, width/8);
        Ellipse2D frontWheel = new Ellipse2D.Double(x + width * 3/4, y + width/3, width/8, width/8);
        Line2D windShield = new Line2D.Double(x + width * 3/4, y, x + width, y + width/6);

        this.addShape(cockpit);
        this.addShape(body);
        this.addShape(rearWheel);
        this.addShape(frontWheel);
        this.addShape(windShield);
    }
}

