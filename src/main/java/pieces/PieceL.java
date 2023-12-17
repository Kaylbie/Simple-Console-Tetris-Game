package pieces;

public class PieceL extends GamePiece {
    public PieceL(int row, int col) {
        super(row, col);
        this.shape = new int[][]{
            {0, 0, 1},
            {1, 1, 1}
        };
    }
    @Override
    public GamePiece clone() {
        return new PieceL(this.row, this.col);
    }
}
