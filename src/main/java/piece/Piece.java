package piece;

public class Piece {
    private int row;
    private int col;
    private PieceType type;
    private int[][] shape;

    public Piece(PieceType type, int row, int col) {
        this.type = type;
        this.shape = type.getShape();
        this.row = row;
        this.col = col;
    }
    public boolean isFilled(int row, int col) {
        if (row >= 0 && row < shape.length && col >= 0 && col < shape[row].length) {
            return shape[row][col] == 1;
        } else {
            return false;
        }
    }
    public Piece clone() {
        Piece newPiece = new Piece(this.type, this.row, this.col);
        newPiece.shape = this.shape;
        return newPiece;
    }

    public static Piece randomPiece() {
        PieceType[] types = PieceType.values();
        int randomIndex = (int) (Math.random() * types.length);
        return new Piece(types[randomIndex], 0, 0);
    }

    public int getCol() {
        return col;
    }
    public int getRow() {
        return row;
    }
    public int[][] getShape() {
        return shape;
    }
    public void setShape(int[][] rotated) {
        this.shape = rotated;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public PieceType getType() {
        return type;
    }
}