package board;

public class BoardRender {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    public void printGameStatus(Board board, int score) {
        printBoard(board);
        System.out.println("Score: " + score);
        System.out.println("Commands (A-left/D-right/S-down/W-rotate): ");
    }
    public void printGameOver(int score) {
        System.out.println("Game over! Your score: " + score);
    }
    private void printBoard(Board board) {
        System.out.println("+" + "-".repeat(board.getWidth()) + "+");
        for (int row = 0; row < board.getHeight(); row++) {
            printRow(board, row);
        }
        System.out.println("+" + "-".repeat(board.getWidth()) + "+");
    }

    private void printRow(Board board, int row) {
        System.out.print("|");
        for (int col = 0; col < board.getWidth(); col++) {
            printCell(board, row, col);
        }
        System.out.println("|");
    }

    private void printCell(Board board, int row, int col) {
        if (board.isCellOccupied(row, col)) {
            System.out.print(ANSI_RED + "X" + ANSI_RESET);
        } else {
            System.out.print(" ");
        }
    }
}
