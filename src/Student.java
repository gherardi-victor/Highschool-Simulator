import java.util.Random;

public class Student extends Thread{
    static Random random = new Random();
    public int playerSpeed = 1;
    public boolean testCompleted = false;
    public int progress = 0;
    public Student(){
        this.start();
    }
    // test progress
    public void run() {
        int MIN_WAIT = App.GAME_SEC / 100;
        int MAX_WAIT = MIN_WAIT * 4;
        for(int i = 0; i < 100; i++){
            if(!App.PLAYING) return;
            try {
                this.progress = i;
                System.out.println(this.progress);
                int wait = Student.random.nextInt(MAX_WAIT - MIN_WAIT) + MIN_WAIT;

                sleep((wait / this.playerSpeed) * 1000L);
            } catch (Exception e) {
                System.out.println("errore nel progresso della verifica: " + e.getMessage());
            }
        }
        // lo studente ha finito la verifica, cambiare lo stato e cambiare immagine
        this.testCompleted = true;
        // chiamare un metodo su app per controllare se tutti gli bstudenti hanoo fnito il test, se tutti finito cambio variabile e profe si ferma
    }
}
