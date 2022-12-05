import java.util.Random;

public class Teacher extends Thread{
    static Random random = new Random();
    public Teacher(){
        //this.start();
    }
    static int x = 0;
    static int y = 0;
    // da sostituire con le ccordinate dei pointer del profe
    public static int[][] location = {
            {x, y}, {x, y}, {x, y}, {x, y}, {x, y},
            {x, y}, {x, y}, {x, y}, {x, y}, {x, y},
            {x, y}, {x, y}, {x, y}, {x, y}, {x, y},
            {x, y}, {x, y}, {x, y}, {x, y}, {x, y},
                            {x, y}
    };
    // i numeri qui dentro si riferiscono alla posizione nell'array sopra, devono iniziare con la cattedra e finire con la cattedra
    public static int[][] paths = {{1,4,5,6}, {1,5,2,7}, {3,6,2,2}, {3,6,2,6}, {7,8,9,3}, {3,8,9,2}};
    public void run(){
        int MIN_WAIT = 2;
        int MAX_WAIT = 6;
        while(true){
            // scegliere un percorso random
            int pathNumber = (int) (Math.random() * Teacher.paths.length);
            // cicla quel percorso per trovare le posizioni e spostare il prof
            for(int i = 0; i < Teacher.paths[pathNumber].length; i++){
                try {
                    // per fare la riga qui sotto ci ho dovuto pensare un pochino
                    int newX = Teacher.location[Teacher.paths[pathNumber][i]][0];
                    int newY = Teacher.location[Teacher.paths[pathNumber][i]][1];

                    // cambia la posizione di this...

                    int wait = Teacher.random.nextInt(MAX_WAIT - MIN_WAIT) + MIN_WAIT;
                    sleep(wait * 1000);
                } catch (Exception e) {
                    System.out.println("errore con lo spostamento prof: " + e.getMessage());
                }
            }
        }
    }
}
