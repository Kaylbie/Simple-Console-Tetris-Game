package pieces;

public class PieceJ extends GamePiece {
    public PieceJ(int row, int col) {
        super(row, col);
        this.shape = new int[][]{
            {1, 0, 0},
            {1, 1, 1}
        };
    }
    @Override
    public GamePiece clone() {
        return new PieceJ(this.row, this.col);
    }
}
