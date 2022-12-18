import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class App {
    public static int REAL_TIME = 60;
    public static int GAME_TIME = 6;
    public static int DEFAULT_SPEED = REAL_TIME / GAME_TIME;
    public static int REAL_SEC = REAL_TIME * 60;
    public static int GAME_SEC = GAME_TIME * 60;
    public static boolean PLAYING = false;

    public Student[] students = new Student[12];

    public App(Container container){
        // aggiungo il timer in alto a sinistra
        Clock clock = new Clock();
        container.add(clock.content);

        // crea tutti bottoni
        Button.container = container;
        JButton iniziabtn = Button.crea("inizia");
        JButton button1 = Button.crea("funzione 1");
        JButton button2 = Button.crea("funzione 2");
        JButton button3 = Button.crea("funzione 3");
        container.add(iniziabtn);
        container.add(button1);
        container.add(button2);
        container.add(button3);
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);

        JLabel cattedra = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("cattedra.jpg"))));
        cattedra.setBounds( 100, 100 , 150, 125);
        cattedra.setVisible(true);
        container.add(cattedra);

        Teacher teacher = new Teacher();
        container.add(teacher.content);

        // creo gli studenti
        int x = 0;
        int y = 75;
        int indice = 0;
        for(int i = 0; i < 3; i++){
            x = 400;
            for (int j = 0; j < 4; j++){
                students[indice] = new Student(x, y);
                container.add(students[indice].content);
                container.add(students[indice].progress);
                x += 200;
                indice++;
            }
            y += 150;
        }

        iniziabtn.addActionListener(e -> {
            if(App.PLAYING) return;
            App.PLAYING = true;
            iniziabtn.setEnabled(false);
            clock.start();
            button1.setEnabled(true);
            button2.setEnabled(true);
            button3.setEnabled(true);
            for(int i = 0; i < 12; i++){
                students[i].start();
            }
            teacher.start();
        });

    }
}