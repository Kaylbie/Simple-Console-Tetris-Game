package pieces;

public class PieceZ extends GamePiece {
    public PieceZ(int row, int col) {
        super(row, col);
        this.shape = new int[][]{
            {1, 1, 0},
            {0, 1, 1}
        };
    }
    @Override
    public GamePiece clone() {
        return new PieceZ(this.row, this.col);
    }
}
