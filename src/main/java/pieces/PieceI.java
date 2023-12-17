package pieces;

public class PieceI extends GamePiece {
    public PieceI(int row, int col) {
        super(row, col);
        this.shape = new int[][]{
            {1, 1, 1, 1}
        };
    }
    @Override
    public GamePiece clone() {
        return new PieceI(this.row, this.col);
    }
}
