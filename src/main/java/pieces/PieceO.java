package pieces;

public class PieceO extends GamePiece {
    public PieceO(int row, int col) {
        super(row, col);
        this.shape = new int[][]{
            {1, 1},
            {1, 1}
        };
    }
    @Override
    public GamePiece clone() {
        return new PieceO(this.row, this.col);
    }
}
