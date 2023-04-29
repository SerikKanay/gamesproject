import java.util.Scanner;
public class Games {
    static String playerName1 = "Player#1";
    static String playerName2 = "Player#2";
    static Scanner scanner = new Scanner(System.in);
    static int[][] battlefield1 = new int[10][10];
    static int[][] battlefield2 = new int[10][10];
    static int[][] monitor1 = new int[10][10];
    static int[][] monitor2 = new int[10][10];
    public static void main(String[] args) {
        System.out.println("Player#1, please enter your name:");
        playerName1 = scanner.nextLine();
        System.out.println("Player#2, please enter your name:");
        playerName2 = scanner.nextLine();
        placeShips(playerName1, battlefield1);
        placeShips(playerName2, battlefield2);
    }
    public static void placeShips(String playerName, int[][] battlefield) {
        int deck = 4;
        while (deck >= 1) {
            System.out.println();
            System.out.println(playerName + ", please place your " + deck + "-deck ship on the battlefield:");
            System.out.println();

            drawField(battlefield);

            System.out.println("Please enter OX coordinate:");
            int x = scanner.nextInt();
            System.out.println("Please enter OY coordinate:");
            int y = scanner.nextInt();
            System.out.println("Choose direction:");
            System.out.println("1. Vertical.");
            System.out.println("2. Horizontal.");
            int direction = scanner.nextInt();
            for (int i = 0; i < deck; i++) {
                if (direction == 1) {
                    battlefield[x][y + i] = 1;
                } else {
                    battlefield[x + i][y] = 1;
                }
            }
            deck--;
        }
    }
    public static void drawField(int[][] battlefield) {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < battlefield.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < battlefield[1].length; j++) {
                if (battlefield[j][i] == 0) {
                    System.out.print("* ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
    public static void makeTurn(String playerName, int[][] monitor) {
        while (true) {
            System.out.println(playerName + ", please, make your turn.");
            System.out.println("  0 1 2 3 4 5 6 7 8 9");
            for (int i = 0; i < monitor.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < monitor[1].length; j++) {
                    if (monitor[j][i] == 0) {
                        System.out.print("* ");
                    } else if (monitor[j][i] == 1) {
                        System.out.print(". ");
                    } else {
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
            System.out.println("Please enter OX coordinate:");
            int x = scanner.nextInt();
            System.out.println("Please enter OY coordinate:");
            int y = scanner.nextInt();
        }
    }
}