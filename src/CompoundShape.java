import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public abstract class CompoundShape extends SelectableShape {
    private Path2D path;

    public CompoundShape() {
        path = new Path2D.Double();
    }

    @Override
    public void draw(Graphics2D g) {
        g.draw(path);
    }

    @Override
    public void translate(double dx, double dy) {
        path.transform(AffineTransform.getTranslateInstance(dx, dy));
    }

    @Override
    public boolean contains(Point2D p) {
        return path.contains(p);
    }

    protected void addShape(Shape s) {
        path.append(s, false);
    }
}
