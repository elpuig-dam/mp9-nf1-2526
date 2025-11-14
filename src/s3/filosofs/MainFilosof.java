package s3.filosofs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainFilosof {

        public static Object lock = new Object();
        public static Lock lock1 = new ReentrantLock();

        public static void main(String[] args) {
            Tenedor t1 = new Tenedor();
            Tenedor t2 = new Tenedor();
            Tenedor t3 = new Tenedor();
            Tenedor t4 = new Tenedor();
            Filosof f1 = new Filosof(t1, t2, "Platon");
            Filosof f2 = new Filosof(t2, t3, "Aristoteles");
            Filosof f3 = new Filosof(t3, t4, "Nitsche");
            Filosof f4 = new Filosof(t4, t1, "Gantt");

            f1.start();
            f2.start();
            f3.start();
            f4.start();

        }
    }