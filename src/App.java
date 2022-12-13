import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    public static int REAL_TIME = 60;
    public static int GAME_TIME = 1;
    public static int DEFAULT_SPEED = REAL_TIME / GAME_TIME;
    public static int REAL_SEC = REAL_TIME * 60;
    public static int GAME_SEC = GAME_TIME * 60;
    public static boolean PLAYING = true;

    public App(Container container){
        // aggiungo il timer in alto a sinistra
        Clock clock = new Clock();
        container.add(clock.content);

        // crea tutti bottoni e gli eventi associati
        Button.container = container;
        JButton iniziabtn = Button.crea("inizia");
        iniziabtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("action listener");
                inizia();
            }
        });

        JButton button1 = Button.crea("funzione 1");
        JButton button2 = Button.crea("funzione 2");
        JButton button3 = Button.crea(" funzione 3");
        iniziabtn.setEnabled(true);
        container.add(iniziabtn);
        container.add(button1);
        container.add(button2);
        container.add(button3);


    }

    public void inizia(){

    }
}