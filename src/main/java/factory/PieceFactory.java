package factory;

import pieces.*;

public class PieceFactory {
    static final int NUM_PIECES = 7;
    public static GamePiece createRandomPiece(int row, int col) {
        int randomIndex = (int) (Math.random() * NUM_PIECES);
        switch (randomIndex) {
            case 0:
                return new PieceI(row, col);
            case 1:
                return new PieceJ(row, col);
            case 2:
                return new PieceL(row, col);
            case 3:
                return new PieceO(row, col);
            case 4:
                return new PieceS(row, col);
            case 5:
                return new PieceT(row, col);
            case 6:
                return new PieceZ(row, col);
            default:
                throw new IllegalArgumentException("Invalid index");
        }
    }
}