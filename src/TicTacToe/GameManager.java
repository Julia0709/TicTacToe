package TicTacToe;

import java.util.Random;
import java.util.Scanner;

class GameManager {
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private static final char[] SYMBOLS = {' ', 'O', 'X'};
    private int player;

    GameManager(int n) {
        switch (n) {
            case 1:
                System.out.println("Player1 vs Player2\n");
                break;
            case 2:
                System.out.println("Player1 vs COM\n");
                break;
            default:
                System.out.println("Please enter 1 or 2");
        }

        player = 1;
        boolean gameFinish = false;

        while (!gameFinish) {

            int x, y;
            if (n == 2 && player == 2) {
                System.out.println("COM: make your move");
                x = makeRandomMove();
                y = makeRandomMove();
            } else {
                System.out.println("Player" + player + ": make your move");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
                y = scan.nextInt();
                if (!checkInput(x, y)) {
                    continue;
                }
            }

            board[y][x] = SYMBOLS[player];

            displayBoard();
            gameFinish = judgeGame(board);

            player = switchTurn(player);
        }
    }

    private int switchTurn(int player) {
        switch (player) {
            case 1:
                return 2;
            case 2:
                return 1;
        }
        return 0;
    }

    private int makeRandomMove() {
        Random random = new Random();
        return random.nextInt(3);
    }

    private void displayBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("+-----------+");
            for (int j = 0; j < 3; j++) {
                System.out.printf("| " + String.valueOf(board[i][j]) + " ");
            }
            System.out.printf("|");
            System.out.printf("\n");
        }
        System.out.println("+-----------+");
    }

    private boolean checkInput(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3 || board[y][x] == 'O' || board[y][x] == 'X') {
            System.out.println("Can't make it. Please enter your move again.");
            return false;
        }
        return true;
    }

    private boolean judgeGame(char[][] board) {

        if (((board[0][0] == 'O' || board[0][0] == 'X') && (board[0][0] == board[1][0] && board[0][0] == board[2][0])) ||
                ((board[0][1] == 'O' || board[0][1] == 'X') && (board[0][1] == board[1][1] && board[0][1] == board[2][1])) ||
                ((board[0][2] == 'O' || board[0][2] == 'X') && (board[0][2] == board[1][2] && board[0][2] == board[2][2])) ||
                ((board[0][0] == 'O' || board[0][0] == 'X') && (board[0][0] == board[0][1] && board[0][0] == board[0][2])) ||
                ((board[1][0] == 'O' || board[1][0] == 'X') && (board[1][0] == board[1][1] && board[1][0] == board[1][2])) ||
                ((board[2][0] == 'O' || board[2][0] == 'X') && (board[2][0] == board[2][1] && board[2][0] == board[2][2])) ||
                ((board[0][0] == 'O' || board[0][0] == 'X') && (board[0][0] == board[1][1] && board[0][0] == board[2][2])) ||
                ((board[0][2] == 'O' || board[0][2] == 'X') && (board[0][2] == board[1][1] && board[0][2] == board[2][0]))) {
            System.out.println("Player" + player + " WIN!\nGAME OVER");
            return true;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    System.out.println("Good!");
                    return false;
                }
            }
        }
        System.out.println("DRAW\nGAME OVER");
        return true;
    }
}
