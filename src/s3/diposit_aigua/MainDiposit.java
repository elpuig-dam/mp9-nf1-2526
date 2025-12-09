package s3.diposit_aigua;

import java.util.Scanner;

public class MainDiposit {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int op;

        Diposit diposit = new Diposit();
        Bomba thBomba = null;
        Valvula thValvula = null;

        do {
            System.out.print("1-Omplir, 2-Buidar, 3-Info Dipòsit, 0-Sortir: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Iniciant la bomba...");

                    if(thBomba != null && thBomba.isAlive()) System.out.println("La bomba ja està en marxa.");
                    else {
                        thBomba = new Bomba(diposit);
                        thBomba.start();
                    }
                    break;
                case 2:
                    if (diposit.getNivell() >= 50) {
                        System.out.println("Obrint la vàlvula...");
                        thValvula = new Valvula(diposit);
                        thValvula.start();
                    } else {
                        System.out.println("El nivell del dipòsit és inferior al 50%. No es pot obrir la vàlvula.");
                    }
                    break;
                case 3:
                    System.out.printf("El nivell del dipòsit és %d%%\n", diposit.getNivell());
                    break;
            }
        } while (op != 0);
    }
}