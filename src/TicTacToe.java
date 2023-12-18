import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean gameEnded;
    private Random random;

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        gameEnded = false;
        random = new Random();
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        printBoard();

        while (!gameEnded) {
            if (currentPlayer == 'X') {
                playerTurn(scanner);
            } else {
                aiTurn();
            }
            printBoard();
            checkGameEnd();
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private void playerTurn(Scanner scanner) {
        int row, col;
        do {
            System.out.println("Player " + currentPlayer + ", enter row and column (1-3):");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != ' ');

        board[row][col] = currentPlayer;
    }

    private void aiTurn() {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board[row][col] != ' ');

        System.out.println("AI placed " + currentPlayer + " in position " + (row + 1) + ", " + (col + 1));
        board[row][col] = currentPlayer;
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-+-+-");
        }
    }

    private void checkGameEnd() {
        // Check rows, columns and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                printWinner(board[i][0]);
                return;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                printWinner(board[0][i]);
                return;
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            printWinner(board[0][0]);
            return;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            printWinner(board[0][2]);
            return;
        }

        // Check for tie
        boolean boardFull = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    boardFull = false;
                    break;
                }
            }
            if (!boardFull) break;
        }

        if (boardFull) {
            System.out.println("It's a tie!");
            gameEnded = true;
        }
    }

    private void printWinner(char player) {
        System.out.println("Player " + player + " wins!");
        gameEnded = true;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }
}
