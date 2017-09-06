package TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("WELCOME TO TIC TAC TOE!");
        System.out.println("Designer: Yuria Nishimura\nClass: Cornerstone WMDP\nDate: 09/05/2017");
        System.out.println("\n1 --- person vs person\n2 --- person vs random COM\n\nEnter your choice (1 or 2)");

        Scanner scan = new Scanner(System.in);
        new GameManager(scan.nextInt());
    }
}
