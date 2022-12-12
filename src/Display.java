import javax.swing.*;
import java.awt.*;

public class Display extends JFrame {
    // private Canvas canvas;
    public Display(int width, int height){
        setVisible(true);
        setTitle("Highschool simulator");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // setResizable(false);

        setSize(width, height);
        setLayout(null);

        setLocationRelativeTo(null);
        init();
    }

    public void init(){
        System.out.println("program started");
        //App app = new App();

        Container container=getContentPane();
        container.setLayout(null);

        JPanel panel = new JPanel();
        JPanel gamePanel = new JPanel();

        Clock clock = new Clock();
        container.add(clock.tempo);

        panel.setVisible(true);
        gamePanel.setVisible(true);

        panel.setLayout(null);
        gamePanel.setLayout(null);

        panel.setBounds(0,0,300,850);
        gamePanel.setBounds(300,0,1440,850);

        panel.setBackground(Color.green);
        gamePanel.setBackground(Color.red);;
        container.add(panel);
        container.add(gamePanel);

        //bottoni
        JButton bottone1 = new JButton("bottone 1");
        bottone1.setBounds(10, 10, 100, 50);
        panel.add(bottone1);


        // Clock clock = new Clock();
        // Student victor = new Student();
        // Teacher rina = new Teacher();
    }
}
