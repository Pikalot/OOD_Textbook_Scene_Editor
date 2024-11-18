import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SceneEditor {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scene Editor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocation(600, 300);

        SceneComponent scene = new SceneComponent();

        JButton carButton = new JButton("Car");
        carButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scene.addShape(new CarShapeCom(30, 30, 60));
            }
        });

        JButton houseButton = new JButton("House");
        houseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scene.addShape(new HouseShapeCom(30, 30, 60));
            }
        });

        JButton removeButton = new JButton("Remove");
        removeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                scene.removeSelection();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(carButton);
        buttons.add(houseButton);
        buttons.add(removeButton);

        frame.setLayout(new BorderLayout());
        frame.add(buttons, BorderLayout.NORTH);
        frame.add(scene, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}