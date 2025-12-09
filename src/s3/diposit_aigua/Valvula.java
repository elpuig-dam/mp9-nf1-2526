package s3.diposit_aigua;

public class Valvula extends Thread {
    private Diposit diposit;

    public Valvula(Diposit diposit) {
        this.diposit = diposit;
    }

    @Override
    public void run() {
        while (diposit.getNivell() > 0) {
            diposit.buidar();
            try {
                Thread.sleep(100); // Sleep for 1 second before draining again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Dipòsit buit");
    }
}