import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class App {
    public static int REAL_TIME = 60;
    public static int GAME_TIME = 4;
    public static int DEFAULT_SPEED = REAL_TIME / GAME_TIME;
    public static int REAL_SEC = REAL_TIME * 60;
    public static int GAME_SEC = GAME_TIME * 60;
    public static boolean PLAYING = false;

    JButton inizia_btn;
    JButton uscita_prof_btn;
    JButton copia_telefono_btn;
    JButton suggerimento_btn;
    public Student[] students = new Student[12];

    public App(Container container){
        // aggiungo il timer in alto a sinistra
        Clock clock = new Clock();
        container.add(clock.content);
        Clock.container = container;
        // crea tutti bottoni
        Button.container = container;
        inizia_btn = Button.crea("inizia");
        uscita_prof_btn = Button.crea("uscita prof");
        copia_telefono_btn = Button.crea("copia telefono");
        suggerimento_btn = Button.crea("suggerimento");
        container.add(inizia_btn);
        container.add(uscita_prof_btn);
        container.add(copia_telefono_btn);
        container.add(suggerimento_btn);
        uscita_prof_btn.setEnabled(false);
        copia_telefono_btn.setEnabled(false);
        suggerimento_btn.setEnabled(false);

        JLabel cattedra = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("cattedra.jpg"))));
        cattedra.setBounds(660, 520 , 230, 125);
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

        Clock.studenti = students;

        inizia_btn.addActionListener(e -> {
            if(App.PLAYING) return;
            App.PLAYING = true;
            inizia_btn.setEnabled(false);
            clock.start();
            uscita_prof_btn.setEnabled(true);
            copia_telefono_btn.setEnabled(true);
            suggerimento_btn.setEnabled(true);
            for(int i = 0; i < 12; i++){
                students[i].start();
            }
            teacher.start();
        });

        Event.studenti = students;
        Event.professore = teacher;
        copia_telefono_btn.addActionListener(e -> {
            new Event(1, 5000, copia_telefono_btn).start();
        });

        suggerimento_btn.addActionListener(e -> {
            new Event(2, 3500, suggerimento_btn).start();
        });

        uscita_prof_btn.addActionListener(e -> {
            new Event(3, 4000, uscita_prof_btn).start();
        });
    }
}