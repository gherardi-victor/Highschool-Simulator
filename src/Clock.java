public class Clock extends Thread {
    public Clock(){
        this.start();
    }
    public void run(){
        for(int sec = 0; sec < App.REAL_SEC; sec++){
            String m = Integer.toString((int)(59 - Math.floor(sec / 60)));
            String s = Integer.toString((int)(59 - Math.floor(sec % 60)));
            while(m.length() < 2) m = "0" + m;
            while(s.length() < 2) s = "0" + s;
            System.out.println(m + ":" + s);

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
