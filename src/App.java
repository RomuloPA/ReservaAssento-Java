import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    static char[][] assentos = new char[18][24];

    static List<int[]> assentosVazios = new ArrayList<>();

    static boolean[][] assentosReservados = new boolean[18][24];

    public static void main(String[] args) throws Exception {

        while (true) {
            limparTela();
            System.out.println();
            System.out.println("Bem vindo ao Cinema Pipoca!");
            System.out.println("Clique no botão ENTER para prosseguir:");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            fluxoSistema(scanner);
        }
    }

    public static void fluxoSistema(Scanner scanner) {

        boolean sair = false;
        limparTela();
        vetorAssentos();
        exibirAssentos();
        reservarAssento();
        /* limparTela(); */
        exibirAssentos();

        while (!sair) {
            System.out.print("Deseja fazer outra reserva? (S/N): ");
            String escolha = scanner.nextLine();

            if (escolha.equalsIgnoreCase("N")) {
                sair = true;
                break;
            } else if (escolha.equalsIgnoreCase("S")) {
                limparTela();
                exibirAssentos();
                reservarAssento();
                /* limparTela(); */
                exibirAssentos();
            } else {
                System.out.println("Opção inválida! Digite 'S' ou 'N'.");
            }
        }
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
        System.out.println("           ----------------------------------------------------------");
        System.out.println("          |                        T  E  L  A                        |");
        System.out.println("           ----------------------------------------------------------");
        System.out.println();
        System.out.println();

        for (int i = 0; i < 18; i++) {
            System.out.print(fileira + "  ");
            for (int j = 0; j < 24; j++) {
                if (isAssentoVazio(i, j)) {
                    System.out.print("   ");
                } else {
                    if (assentos[i][j] == 'X') {
                        System.out.print("\u001B[31m[X]\u001B[0m");
                    } else {
                        System.out.print("\u001B[32m[" + assentos[i][j] + "]\u001B[0m");
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

        while (true) {
            System.out.print("Digite a linha da fileira (A a R): ");
            String fileiraEscolhida = scanner.nextLine();
            char fileira = fileiraEscolhida.toUpperCase().charAt(0);

            System.out.print("Digite o número da coluna (1 a 24): ");
            int coluna = Integer.parseInt(scanner.nextLine());

            if (fileira >= 'A' && fileira <= 'R' && coluna >= 1 && coluna <= 24) {
                int linhaIndex = fileira - 'A';
                int colunaIndex = coluna - 1;

                boolean isAssentoVazio = false;
                for (int[] assentoVazio : assentosVazios) {
                    if (assentoVazio[0] == linhaIndex && assentoVazio[1] == colunaIndex) {
                        isAssentoVazio = true;
                        break;
                    }
                }

                if (isAssentoVazio) {
                    System.out.println("Linha ou coluna inválida!");
                } else if (assentos[linhaIndex][colunaIndex] == 'O') {
                    assentos[linhaIndex][colunaIndex] = 'X';
                    limparTela();
                    System.out.println("Assento reservado com sucesso!");
                    return;
                } else {
                    System.out.println("Assento já está ocupado!");
                }
            } else {
                System.out.println("Linha ou coluna inválida!");
            }
        }
    }

    public static void limparTela() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
