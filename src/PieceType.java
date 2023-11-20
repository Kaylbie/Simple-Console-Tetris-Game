public enum PieceType
{
    I(new int[][]{
            {1, 1, 1, 1} // I shape
    }),
    J(new int[][]{
            {1, 0, 0},
            {1, 1, 1}  // J shape
    }),
    L(new int[][]{
            {0, 0, 1},
            {1, 1, 1}  // L shape
    }),
    O(new int[][]{
            {1, 1},
            {1, 1}  // O shape
    }),
    S(new int[][]{
            {0, 1, 1},
            {1, 1, 0}  // S shape
    }),
    T(new int[][]{
            {0, 1, 0},
            {1, 1, 1}  // T shape
    }),
    Z(new int[][]{
            {1, 1, 0},
            {0, 1, 1}  // Z shape
    });
//    TEST(new int[][]{
//            {1},
//            {1},
//            {1},
//            {1},
//            {1},
//            {1},
//            {1},
//            {1},
//            {1},
//            {1} // TEST shape
//    });


    private int[][] shape;

    PieceType(int[][] shape)
    {
        this.shape = shape;
    }

    public int[][] getShape()
    {
        return shape;
    }
}
