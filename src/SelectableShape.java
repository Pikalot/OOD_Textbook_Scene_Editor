import java.awt.*;

public abstract class SelectableShape implements SceneShape {
    private boolean selected;

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean s) {
        selected = s;
    }

    // Template method
    @Override
    public void drawSelection(Graphics2D g) {
        translate(1, 1);
        draw(g);
        translate(1, 1);
        draw(g);
        translate(1, 1);
        draw(g);
        translate(-3, -3);
    }
}