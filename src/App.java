public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Reserva Assento");
        exibirAssentos();
    }

    public static void exibirAssentos() {
        char fileira = 'A';
        int linha = 1;

        System.out.println("           -------------------------------------------------------");
        System.out.println("          |                       T  E  L  A                      |");
        System.out.println("           -------------------------------------------------------");
        System.out.println();
        System.out.println();

        while (fileira <= 'D') {
            System.out.print(fileira + "              ");

            for (int i = 0; i < 16; i++) {
                System.out.print("[O]");
            }

            System.out.println();
            fileira++;
        }

        System.out.println();

        while (fileira <= 'G') {
            System.out.print(fileira + "              ");

            for (int i = 0; i < 16; i++) {
                System.out.print("[O]");
            }

            System.out.println();
            fileira++;
        }

        while (fileira <= 'P') {
            System.out.print(fileira + " ");

            for (int i = 0; i < 4; i++) {
                System.out.print("[O]");
            }

            System.out.print(" ");

            for (int i = 0; i < 16; i++) {
                System.out.print("[O]");
            }

            System.out.print(" ");

            for (int i = 0; i < 4; i++) {
                System.out.print("[O]");
            }

            System.out.println();
            fileira++;
        }

        System.out.println();

        while (fileira <= 'R') {
            System.out.print(fileira + "              ");

            for (int i = 0; i < 16; i++) {
                System.out.print("[O]");
            }

            System.out.println();
            fileira++;
        }

        System.out.println();
        System.out.print(" ");

        for (int i = 0; i <= 3; i++) {
            System.out.print(" ");
            for (int j = 0; j <= 3; j++) {
                if (j == 0) {
                    System.out.print(" " + linha);
                    linha++;
                }
            }
        }

        System.out.print(" ");

        for (int i = 4; i <= 8; i++) {
            System.out.print(" ");
            for (int j = 4; j <= 8; j++) {
                if (j == 4) {
                    System.out.print(" " + linha);
                    linha++;
                }
            }
        }

        for (int i = 9; i <= 19; i++) {
            for (int j = 9; j <= 19; j++) {
                if (j == 9) {
                    System.out.print(" " + linha);
                    linha++;
                }
            }
        }

        System.out.print(" ");

        for (int i = 20; i <= 23; i++) {
            for (int j = 20; j <= 23; j++) {
                if (j == 20) {
                    System.out.print(" " + linha);
                    linha++;
                }
            }
        }
    }

}
