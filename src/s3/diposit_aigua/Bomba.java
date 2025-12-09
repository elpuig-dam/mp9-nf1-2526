package s3.diposit_aigua;

public class Bomba extends Thread {
    private Diposit diposit;

    public Bomba(Diposit diposit) {
        this.diposit = diposit;
    }

    @Override
    public void run() {
        while (diposit.getNivell() < 100) {
            diposit.omplir();
            try {
                Thread.sleep(20); // Sleep for 1 second before filling again
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Dipòsit ple");
    }
}
