import javax.swing.*;

public class Event extends Thread{
    public static Student[] studenti;
    public int comando;
    public int secondi;
    public static Teacher professore;
    public JButton bottone;
    public Event(int i, int s, JButton button){
        comando = i;
        secondi = s;
        bottone = button;
    }
    public void run(){
        bottone.setEnabled(false);
        if(comando == 1){
            int random;
            do {
                random = (int)(Math.random() * Event.studenti.length);
            }while (Event.studenti[random].testCompleted);
            Event.studenti[random].playerSpeed = 4;
            try {
                sleep(secondi);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            Event.studenti[random].playerSpeed = 1;
        }
        if(comando == 2){
            for(int i = 0; i < Event.studenti.length; i++){
                Event.studenti[i].playerSpeed = 3;
            }
            try {
                sleep(secondi);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            for(int i = 0; i < Event.studenti.length; i++){
                Event.studenti[i].playerSpeed = 1;
            }
        }
        if(comando == 3){
            professore.content.setVisible(false);
            for(int i = 0; i < Event.studenti.length; i++){
                Event.studenti[i].playerSpeed = 3;
            }
            try {
                sleep(secondi);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            for(int i = 0; i < Event.studenti.length; i++){
                Event.studenti[i].playerSpeed = 1;
            }
            professore.content.setVisible(true);
        }
        try {
            sleep(secondi* 2);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
        bottone.setEnabled(true);
    }
}
