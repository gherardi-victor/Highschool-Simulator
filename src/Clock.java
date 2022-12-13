import javax.swing.*;
import java.awt.*;

public class Clock extends Thread {
    public String time;
    public JLabel content;
    public Clock(){
        content = new JLabel("60:00");
        content.setFont(new Font("Helvetica Neue", Font.BOLD, 28));
        content.setBounds(220, 10, 100, 50);
        content.setVisible(true);
    }

    public void run(){

        for(int sec = 0; sec < App.REAL_SEC; sec++){
            // se mancano meno di 10 minuti metti il clock in rosso
            if((int)(59 - Math.floor(sec / 60)) < 10) content.setForeground(Color.red);

            // aggiornare il clock
            String m = Integer.toString((int)(59 - Math.floor(sec / 60)));
            String s = Integer.toString((int)(59 - Math.floor(sec % 60)));
            while(m.length() < 2) m = "0" + m;
            while(s.length() < 2) s = "0" + s;
            content.setText(m + ":" + s);

            try {
                sleep(1000 / App.DEFAULT_SPEED);
            } catch (Exception e) {
                System.out.println("errore nel clock: " + e.getMessage());
            }
        }
        // fare controllo tra gli studenti, se c'è ne uno che non ha finito perdi la partita
        System.out.println("test ended");
    }
}
