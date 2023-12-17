package pieces;

public abstract class GamePiece {
    protected int row;
    protected int col;
    protected int [][] shape;

    public GamePiece(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public abstract GamePiece clone();

    public void rotate() {
        int[][] rotatedShape = new int[shape[0].length][shape.length];
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                rotatedShape[j][shape.length - 1 - i] = shape[i][j];
            }
        }
        shape = rotatedShape;
    }
    public boolean isFilled(int row, int col) {
        if (row >= 0 && row < shape.length && col >= 0 && col < shape[row].length) {
            return shape[row][col] == 1;
        } else {
            return false;
        }
    }
    //getSET
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getShape() {
        return shape;
    }
}
