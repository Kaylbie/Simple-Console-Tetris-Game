package pieces;

public class PieceS extends GamePiece {
    public PieceS(int row, int col) {
        super(row, col);
        this.shape = new int[][]{
            {0, 1, 1},
            {1, 1, 0}
        };
    }
    @Override
    public GamePiece clone() {
        return new PieceS(this.row, this.col);
    }
}
