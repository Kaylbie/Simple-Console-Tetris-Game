package control;

import board.Board;
import factory.PieceFactory;
import main.Tetris;
import pieces.GamePiece;

public class PieceControl {
    private final int defaultRow = 0;
    private final int moveOneStep = 1;
    private final int halfWidth = 2;
    private Board board;
    private GamePiece currentPiece;

    public PieceControl(Board board) {
        this.board = board;
        spawnNewPiece();
    }

    public void spawnNewPiece() {
        currentPiece = PieceFactory.createRandomPiece(defaultRow, defaultRow);
        currentPiece.setRow(defaultRow);
        currentPiece.setCol(calculateColOffset(currentPiece));
        if (!board.canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol())) {
            Tetris.setGameOver();
        }
    }
    private int calculateColOffset(GamePiece currentPiece) {
        return board.getWidth() / halfWidth - currentPiece.getShape()[0].length / halfWidth;
    }




    public void movePieceDown() {
        if (board.canMove(currentPiece, currentPiece.getRow() + moveOneStep, currentPiece.getCol())) {
            currentPiece.setRow(currentPiece.getRow() + moveOneStep);
        } else {
            board.fixToGrid();
            spawnNewPiece();
        }
    }
    public void movePieceLeft() {
        if (board.canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol() - moveOneStep)) {
            currentPiece.setCol(currentPiece.getCol() - moveOneStep);
        }
    }
    public void movePieceRight() {
        if (board.canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol() + moveOneStep)) {
            currentPiece.setCol(currentPiece.getCol() + moveOneStep);
        }
    }
    public void checkForRotationPiece() {
        GamePiece testPiece = currentPiece.clone();
        testPiece.rotate();
        if (board.canMove(testPiece, testPiece.getRow(), testPiece.getCol())) {
            currentPiece.rotate();
        }
    }

    public GamePiece getCurrentPiece() {
        return currentPiece;
    }
}
