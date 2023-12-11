package piece;

public enum PieceType {
    I(new int[][]{
            {1, 1, 1, 1}
    }),
    J(new int[][]{
            {1, 0, 0},
            {1, 1, 1}
    }),
    L(new int[][]{
            {0, 0, 1},
            {1, 1, 1}
    }),
    O(new int[][]{
            {1, 1},
            {1, 1}
    }),
    S(new int[][]{
            {0, 1, 1},
            {1, 1, 0}
    }),
    T(new int[][]{
            {0, 1, 0},
            {1, 1, 1}
    }),
    Z(new int[][]{
            {1, 1, 0},
            {0, 1, 1}
    });

    private int[][] shape;

    PieceType(int[][] shape) {
        this.shape = shape;
    }

    public int[][] getShape() {
        return shape;
    }
}
