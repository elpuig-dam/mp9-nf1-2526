package s3.filosofs;

public class Tenedor {

    public boolean disponible;

    public Tenedor() {
        disponible = true;
    }

    public synchronized void coger(){
        while (disponible=false) {
            try{
                wait();
            }catch (InterruptedException e) {
                throw new RuntimeException();
            }
        }

        disponible=false;
        notifyAll();

    }

    public synchronized void dejar(){
        disponible=true;
        notifyAll();

    }



}
