package pieces;

public class PieceT extends GamePiece {
    public PieceT(int row, int col) {
        super(row, col);
        this.shape = new int[][]{
            {0, 1, 0},
            {1, 1, 1}
        };
    }
    @Override
    public GamePiece clone() {
        return new PieceT(this.row, this.col);
    }
}
