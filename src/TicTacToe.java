import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private final char[][] board; // 3x3 board
    private char currentPlayer; // X or O player turn indicator
    private boolean gameEnded; // true if the game has ended, false otherwise
    private final Random random; // random number generator

    public TicTacToe() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
        gameEnded = false;
        random = new Random(); // random number generator
    }

    // Play the game until it ends (win or tie) and print the winner
    public void playGame() {
        Scanner userInput = new Scanner(System.in);
        printBoard(); // print the initial board

        // Keep playing until the game ends
        while (!gameEnded) {
            // If it's the user's turn (X), prompt for input
            if (currentPlayer == 'X') {
                playerTurn(userInput);
            } else {
                aiTurn(); // if it's the computerizing turn (O), make a random move
            }
            printBoard(); // print the board after the user's move
            checkGameEnd(); // check if the game has ended
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Prompt the user for a row and column to place their move
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
