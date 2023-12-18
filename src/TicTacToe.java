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
                AI_Turn(); // if it's the computerizing turn (O), make a random move
            }
            printBoard(); // print the board after the user's move
            checkGameEnd(); // check if the game has ended

            // Switch players (X to O, O to X) after each move if the game hasn't ended
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Prompt the user for a row and column to place their move
    private void playerTurn(Scanner scanner) {
        int row, column; // row and column to place the user's move
        do {
            System.out.println("Player " + currentPlayer + ", enter row and column (1-3):");

            // Subtract 1 from the user's input since the board is 0-indexed
            row = scanner.nextInt() - 1;

            // Subtract 1 from the user's input since the board is 0-indexed
            column = scanner.nextInt() - 1;

            // Keep prompting the user for a valid move until they enter a valid move
        } while (row < 0 || column < 0 || row >= 3 || column >= 3 || board[row][column] != ' ');

        board[row][column] = currentPlayer; // place the user's move on the board
    }

    private void AI_Turn() {
        int row, column; // row and column to place the AI's move
        do {
            row = random.nextInt(3); // generate random row
            column = random.nextInt(3); // generate random column

            // Keep generating random moves until the AI finds a valid move
        } while (board[row][column] != ' ');

        // Place the AI's move on the board and print it out for the user
        System.out.println("AI placed " + currentPlayer + " in position " + (row + 1) + ", " + (column + 1));
        board[row][column] = currentPlayer; // place the AI's move on the board
    }

    // Print the board to the console
    private void printBoard() {
        System.out.println("-------------");
        System.out.println("| " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |");
        System.out.println("-------------");
    }
//        for (int i = 0; i < 3; i++) {  // print the board Optimal
//            for (int j = 0; j < 3; j++) {
//                System.out.print(board[i][j]);
//                if (j < 2) System.out.print("|");
//            }
//            System.out.println();
//            if (i < 2) System.out.println("-+-+-");
//        }
//    }

    // Check if the game has ended and print the winner (if any)
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

        // Check for tie - if there are no empty spaces left on the board
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
