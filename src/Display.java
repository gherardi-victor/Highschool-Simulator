import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    public static final int PANEL_WIDTH = 200;
    // private Canvas canvas;
    public Display(int width, int height){
        setTitle("Highschool simulator");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(width, height);
        setLayout(null);
        setLocationRelativeTo(null);

        Container container=getContentPane();
        container.setLayout(null);
        container.setBackground(Color.white);

        App app = new App(container);
    }
}
