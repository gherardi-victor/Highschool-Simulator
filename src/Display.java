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

        initComponents(width, height);
    }

    public void initComponents(int w, int h){
        System.out.println("program started");
        // App app = new App();

        Container container=getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        JPanel gamePanel = new JPanel();
        panel.setVisible(true);
        gamePanel.setVisible(true);
        panel.setLayout(null);
        gamePanel.setLayout(null);
        panel.setBounds(0,0,200, h);
        gamePanel.setBounds(200,0,w - 200, h);
        panel.setBackground(Color.green);
        // gamePanel.setBackground(Color.red);

        new App(container);

        // aggiungo i pannelli
        container.add(panel);
        container.add(gamePanel);

    }

    public void inizia(){
        System.out.println("program started");
        App.PLAYING = true;
        // Clock clock = new Clock();
        // Student victor = new Student();
        // Teacher rina = new Teacher();
    }
}
