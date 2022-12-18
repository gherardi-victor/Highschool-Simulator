import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Teacher extends Thread{
    static Random random = new Random();
    public JLabel content;
    public int x = 650;
    public int y = 500;
    public Teacher(){
        content = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getResource("alunno_default.jpg"))));
        content.setBounds(this.x, this.y , 150, 125);
        content.setVisible(true);
    }
    // da sostituire con le ccordinate dei pointer del profe
    public int[][] location = {
            {300, 200}, {x, 200}, {700, 200},
            {300, 350}, {x, 350}, {700, 350},
                         {x, y},
    };
    // i numeri qui dentro si riferiscono alla posizione nell'array sopra, devono iniziare con la cattedra e finire con la cattedra
    public int[][] paths = {{ 5, 2, 1, 0, 3, 4, 6}, { 5, 2, 1, 0, 3, 4, 6}, { 5, 2, 1, 0, 3, 4, 6}, { 5, 2, 1, 0, 3, 4, 6}};
    public void run(){
        int MIN_WAIT = 2;
        int MAX_WAIT = 6;
        // while (!App.verifica_finita), variabile da creare a test
        while (App.PLAYING) {
            // scegliere un percorso random
            int pathNumber = (int) (Math.random() * paths.length);
            // cicla quel percorso per trovare le posizioni e spostare il prof
            for (int i = 0; i < paths[pathNumber].length; i++) {
                try {
                    // per fare la riga qui sotto ci ho dovuto pensare un pochino
                    int newX = location[paths[pathNumber][i]][0];
                    int newY = location[paths[pathNumber][i]][1];

                    // cambia la posizione del content...
                    content.setLocation(newX, newY);

                    int wait = Teacher.random.nextInt(MAX_WAIT - MIN_WAIT) + MIN_WAIT;
                    sleep(wait * 1000);
                } catch (Exception e) {
                    System.out.println("errore con lo spostamento prof: " + e.getMessage());
                }
            }
        }
    }
}
