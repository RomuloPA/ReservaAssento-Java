import java.util.ArrayList;
import java.util.List;

public class App {
    static char[][] assentos = new char[18][24];

    // Lista de coordenadas dos assentos vazios
    static List<int[]> assentosVazios = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Reserva Assento");
        vetorAssentos();
        exibirAssentos();
    }

    public static void vetorAssentos() {
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 24; j++) {
                assentos[i][j] = 'O';
                if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 16 || i == 17) {
                    if (j == 0 || j == 1 || j == 2 || j == 3 || j == 20 || j == 21 || j == 22 || j == 23) {
                        assentosVazios.add(new int[] { i, j });
                    }
                }
            }
        }
    }

    public static void exibirAssentos() {
        char fileira = 'A';
        int linha = 1;

        System.out.println();
        System.out.println("           -------------------------------------------------------");
        System.out.println("          |                       T  E  L  A                      |");
        System.out.println("           -------------------------------------------------------");
        System.out.println();
        System.out.println();

        for (int i = 0; i < 18; i++) {
            System.out.print(fileira + "  ");
            for (int j = 0; j < 24; j++) {
                if (isAssentoVazio(i, j)) {
                    System.out.print("   "); // Assento vazio (três espaços em branco)
                } else {
                    System.out.print("[" + assentos[i][j] + "]");
                }
                if (j == 3) {
                    System.out.print(" ");
                } else if (j == 19) {
                    System.out.print(" ");
                }
            }
            if (fileira == 'D') {
                System.out.println();
            } else if (fileira == 'P') {
                System.out.println();
            }
            System.out.println();
            fileira++;
        }

        System.out.println();
        System.out.print("  ");

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

        System.out.print("  ");

        for (int i = 20; i <= 23; i++) {
            for (int j = 20; j <= 23; j++) {
                if (j == 20) {
                    System.out.print(" " + linha);
                    linha++;
                }
            }
        }

        System.out.println();
        System.out.println();
    }

    public static boolean isAssentoVazio(int linha, int coluna) {
        for (int[] coords : assentosVazios) {
            if (linha == coords[0] && coluna == coords[1]) {
                return true;
            }
        }
        return false;
    }

}
