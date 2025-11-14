package s3.filosofs;

import static s3.filosofs.MainFilosof.lock;

public class Filosof extends Thread {

    private Tenedor t1;
    private Tenedor t2;


    public Filosof(Tenedor t1, Tenedor t2, String nom) {
        super(nom);
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public void run() {
        while (true) {
            comer();
            pensar();
        }

    }

    public void comer() {
        // synchronized (lock) {
        t1.coger();
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        t2.coger();
        System.out.println(getName() + " comiendo...");
        try {
            Thread.sleep((long) (Math.random() * 500) + 50);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        t1.dejar();
        t2.dejar();
    }


    private void pensar() {
        System.out.println(getName() + " pensando...");
        try {
            Thread.sleep((long) (Math.random() * 500) + 50);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}




