package TicTacToe;

import java.util.Scanner;

class GameManager {
    private char[][] board = new char[3][3];
    private static final char[] SYMBOLS = {'O', 'X'};
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

            int x = 0, y = 0;
            if (n == 2 && player == 2) {
                System.out.println("COM: make your move");
                x = COM();
                y = COM();
            } else {
                System.out.println("Player" + player + ": make your move");
                Scanner scan = new Scanner(System.in);
                x = scan.nextInt();
                y = scan.nextInt();
            }

            if (!checkInput(x, y)) {
                continue;
            }

            int i = player - 1;
            board[y][x] = SYMBOLS[i];

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

    private int COM() {
        return (int) (Math.random() * 100 % 3 + 1);
    }

    private void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.printf(String.valueOf(board[i][j]));
            }
            System.out.printf("\n");
        }
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
                if (board[i][j] == '\0') {
                    System.out.println("Good!");
                    return false;
                }
            }
        }
        System.out.println("DRAW");
        return true;
    }
}
