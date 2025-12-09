package s2;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class MCD extends RecursiveTask<Integer> {
    private final int LLINDAR = 10;
    private int a;
    private int b;

    public MCD(int a, int b) {
        this.a = a;
        this.b = b;
    }


    //funció que crida a la clase recursivament
    private Integer mcdRec() {
        System.out.println("rec");
        if(b == 0) return a;
        else {
            MCD mcdTask = new MCD(b, a % b);
            mcdTask.fork();
            return mcdTask.join();
        }

    }

    //funció que resol el mcd de forma iterativa
    private Integer mcdSeq() {
        System.out.println("iter");
        int resto;
        if(b==0) return a;
        else {
            do {
                resto = a % b;
                a = b;
                if (resto != 0) b = resto;
            } while (resto != 0);
            return b;
        }
    }

    @Override
    protected Integer compute() {
        if(a < LLINDAR && b < LLINDAR) {
            return mcdSeq();
        }else return mcdRec();
    }


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        MCD mcd = new MCD(3115,4555);
        MCD mcd2 = new MCD(18,45);

        pool.invoke(mcd);
        int res = mcd.join();

        System.out.println("mcd = " + res);
    }
}
