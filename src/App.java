import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static char[][] assentos = new char[18][24];

    // Lista de coordenadas dos assentos vazios
    static List<int[]> assentosVazios = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        System.out.println("Reserva Assento");
        vetorAssentos();
        exibirAssentos();
        reservarAssento();
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
                    if (assentos[i][j] == 'X') {
                        System.out.print("\u001B[31m[X]\u001B[0m"); // [X] in red
                    } else {
                        System.out.print("\u001B[32m[" + assentos[i][j] + "]\u001B[0m"); // [O] in green
                    }
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

    public static void reservarAssento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a linha da fileira (A a R): ");
        String fileiraEscolhida = scanner.nextLine();
        char fileira = fileiraEscolhida.toUpperCase().charAt(0);

        System.out.print("Digite o número da coluna (1 a 24): ");
        int coluna = Integer.parseInt(scanner.nextLine());

        if (fileira >= 'A' && fileira <= 'R' && coluna >= 1 && coluna <= 24) {
            int linhaIndex = fileira - 'A';
            int colunaIndex = coluna - 1;

            if (!isAssentoVazio(linhaIndex, colunaIndex) && assentos[linhaIndex][colunaIndex] == 'O') {
                assentos[linhaIndex][colunaIndex] = 'X';
                System.out.println("Assento reservado com sucesso!");
            } else {
                System.out.println("Assento já está ocupado ou é inválido!");
            }
        } else {
            System.out.println("Linha ou coluna inválida!");
        }

        scanner.close();
    }

}
