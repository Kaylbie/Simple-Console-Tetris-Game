package factory;

import piece.Piece;
import piece.PieceType;

public class PieceFactory {

    public static Piece createPiece(PieceType type) {
        switch (type) {
            case I:
                return new Piece(PieceType.I, 0, 0);
            case J:
                return new Piece(PieceType.J, 0, 0);
            case L:
                return new Piece(PieceType.L, 0, 0);
            case O:
                return new Piece(PieceType.O, 0, 0);
            case S:
                return new Piece(PieceType.S, 0, 0);
            case T:
                return new Piece(PieceType.T, 0, 0);
            case Z:
                return new Piece(PieceType.Z, 0, 0);
            default:
                throw new IllegalArgumentException("Unknown: " + type);
        }
    }

    public static Piece createRandomPiece() {
        PieceType[] types = PieceType.values();
        int randomIndex = (int) (Math.random() * types.length);
        return createPiece(types[randomIndex]);
    }
}