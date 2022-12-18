import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Student extends Thread{
    public static Random random = new Random();
    public int playerSpeed = 1;
    public boolean testCompleted = false;
    public JLabel progress;
    public JLabel content;
    public Student(int x, int y){
        progress = new JLabel("0%");
        progress.setFont(new Font("Helvetica Neue", Font.BOLD, 16));
        progress.setBounds(x + 110, y + 100, 100, 50);
        progress.setVisible(true);

        content = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("alunno_default.jpg"))));
        //content = new JLabel(new ImageIcon(getClass().getResource("alunno_dafault.jpg")));

        content.setBounds(x, y, 150, 125);
        //label.setOpaque(true);
        content.setVisible(true);

    }
    // test progress
    public void run() {
        content.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("alunno_inizio.JPG"))));
        int MIN_WAIT = App.GAME_SEC / 100;
        int MAX_WAIT = MIN_WAIT * 3;
        for(int i = 0; i < 100; i++){
            if(!App.PLAYING) {
                content.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("alunno_fine.JPG"))));
                return;
            }
            try {
                progress.setText(i + "%");
                int wait = Student.random.nextInt(MAX_WAIT - MIN_WAIT) + MIN_WAIT;
                sleep((wait / this.playerSpeed) * 1000L);
            } catch (Exception e) {
                System.out.println("errore nel progresso della verifica: " + e.getMessage());
            }
        }
        content.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("alunno_fine.JPG"))));
        progress.setText("100%");
        this.testCompleted = true;
        Clock.controllo();
    }
}
