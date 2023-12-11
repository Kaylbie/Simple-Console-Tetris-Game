package controls;

import board.Board;
import factory.PieceFactory;
import piece.Piece;
import main.Tetris;

public class PieceControl {
    private Board board;
    private Piece currentPiece;

    public PieceControl(Board board) {
        this.board = board;
        spawnNewPiece();
    }

    public void spawnNewPiece() {
        //currentPiece = piece.Piece.randomPiece();
        currentPiece = PieceFactory.createRandomPiece();
        currentPiece.setRow(0);
        currentPiece.setCol(board.getWidth() / 2 - currentPiece.getShape()[0].length / 2);
        if (!board.canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol())) {
            Tetris.setGameOver();
        }
    }
    private boolean canPlacePiece(Piece piece) {
        return board.canMove(piece, piece.getRow(), piece.getCol());
    }
    public void movePieceDown() {
        if (board.canMove(currentPiece, currentPiece.getRow() + 1, currentPiece.getCol())) {
            currentPiece.setRow(currentPiece.getRow() + 1);
        } else {
            board.fixToGrid();
            spawnNewPiece();
        }
    }
    public void movePieceLeft() {
        if (board.canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol() - 1)) {
            currentPiece.setCol(currentPiece.getCol() - 1);
        }
    }
    public void movePieceRight() {
        if (board.canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol() + 1)) {
            currentPiece.setCol(currentPiece.getCol() + 1);
        }
    }
    public void rotatePiece() {
        Piece testPiece = new Piece(currentPiece.getType(), currentPiece.getRow(), currentPiece.getCol());
        rotateShape(testPiece);
        if (board.canMove(testPiece, testPiece.getRow(), testPiece.getCol())) {
            rotateShape(currentPiece);
        }
    }
    public void rotateShape(Piece piece) {
        int[][] shape = piece.getShape();
        int[][] rotated = new int[shape[0].length][shape.length];
        for (int row = 0; row < shape.length; row++) {
            for (int col = 0; col < shape[row].length; col++) {
                rotated[col][shape.length - 1 - row] = shape[row][col];
            }
        }
        piece.setShape(rotated);
    }
    public Piece getCurrentPiece() {
        return currentPiece;
    }
}
