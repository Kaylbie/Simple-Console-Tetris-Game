package board;

import control.PieceControl;
import pieces.GamePiece;

public class Board {
    private final int width = 10;
    private final int height = 10;
    private int[][] grid;
    private PieceControl pieceControl;

    public Board() {
        grid = new int[height][width];
        spawnNewPiece();
    }

    public boolean canMove(GamePiece piece, int newRow, int newCol) {
        int[][] shape = piece.getShape();
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                if (isPartOfPiece(shape[row][col])) {
                    if (isOutsideGrid(newRow + row, newCol + col) || isPositionOccupied(newRow + row, newCol + col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean isPartOfPiece(int shapeValue) {
        return shapeValue != 0;
    }
    private boolean isOutsideGrid(int row, int col) {
        return row < 0 || row >= height || col < 0 || col >= width;
    }
    private boolean isPositionOccupied(int row, int col) {
        return grid[row][col] != 0;
    }
    private void spawnNewPiece() {
        if (pieceControl == null) {
            pieceControl = new PieceControl(this);
        } else {
            pieceControl.spawnNewPiece();
        }

    }
    public void fixToGrid() {
        GamePiece currentPiece = pieceControl.getCurrentPiece();
        fixPieceToGrid(currentPiece);
        spawnNewPiece();
    }

    private void fixPieceToGrid(GamePiece piece) {
        int[][] pieceShape = piece.getShape();
        for (int row = 0; row < pieceShape.length; row++) {
            for (int col = 0; col < pieceShape[row].length; col++) {
                if (isPartOfPiece(pieceShape[row][col])) {
                    occupyGridCell(piece, row, col);
                }
            }
        }
    }

    private void occupyGridCell(GamePiece piece, int rowOffset, int colOffset) {
        grid[piece.getRow() + rowOffset][piece.getCol() + colOffset] = 1;
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
    public boolean isCellOccupied(int row, int col) {
        return grid[row][col] == 1 ||
                (pieceControl.getCurrentPiece() != null && pieceControl.getCurrentPiece().isFilled(row - pieceControl.getCurrentPiece().getRow(), col - pieceControl.getCurrentPiece().getCol()));
    }
    public PieceControl getPieceControl() {
        return pieceControl;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public int[][] getGrid() {
        return grid;
    }
}
