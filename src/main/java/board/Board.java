package board;

import piece.Piece;
import controls.PieceControl;

public class Board {
    private int width = 10;
    private int height = 10;
    private int[][] grid;
    private PieceControl pieceControl;

    public Board() {
        grid = new int[height][width];
        spawnNewPiece();
    }

    public boolean canMove(Piece piece, int newRow, int newCol) {
        int[][] shape = piece.getShape();
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (shape[row][col] != 0) {
                    int gridRow = newRow + row;
                    int gridCol = newCol + col;
                    if (gridRow < 0 || gridRow >= height || gridCol < 0 || gridCol >= width) {
                        return false;
                    }
                    if (grid[gridRow][gridCol] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private void spawnNewPiece() {
        //pieceControl = new controls.PieceControl(this);
        if (pieceControl == null) {
            pieceControl = new PieceControl(this);
        } else {
            pieceControl.spawnNewPiece();
        }

    }
    public void fixToGrid() {
        Piece piece = pieceControl.getCurrentPiece();
        for (int row = 0; row < piece.getShape().length; row++) {
            for (int col = 0; col < piece.getShape()[row].length; col++) {
                if (piece.getShape()[row][col] != 0) {
                    grid[piece.getRow() + row][piece.getCol() + col] = 1;
                }
            }
        }
        spawnNewPiece();
    }
    public int clearCompletedLines() {
        int linesCleared = 0;
        for (int row = 0; row < height; row++) {
            if (isLineComplete(row)) {
                clearLine(row);
                linesCleared++;
            }
        }
        return linesCleared;
    }
    private boolean isLineComplete(int row) {
        for (int col = 0; col < width; col++) {
            if (grid[row][col] == 0) {
                return false;
            }
        }
        return true;
    }
    private void clearLine(int line) {
        for (int row = line; row > 0; row--) {
            System.arraycopy(grid[row - 1], 0, grid[row], 0, width);
        }
        grid[0] = new int[width];
    }
    public PieceControl getPieceControl() {
        return pieceControl;
    }
    public int getWidth() {
        return width;
    }
    public boolean isCellOccupied(int row, int col) {
        return grid[row][col] == 1 ||
                (pieceControl.getCurrentPiece() != null && pieceControl.getCurrentPiece().isFilled(row - pieceControl.getCurrentPiece().getRow(), col - pieceControl.getCurrentPiece().getCol()));

    }
}
