public class Piece
{

    private int row;
    private int col;
    private PieceType type;
    private int[][] shape;

    public Piece(PieceType type, int row, int col)
    {
        this.type = type;
        this.shape = type.getShape();
        this.row = row;
        this.col = col;
    }
    public void moveDown()
    {
        row++;
    }

    public void moveLeft()
    {
        col--;
    }
    public void moveRight()
    {
        col++;
    }
    //public void rotate(boolean clockwise) {
    //
    //}

    public int getRow()
    {
        return row;
    }
    public void rotate()
    {
        int[][] rotatedShape = new int[shape[0].length][shape.length];
        for (int row = 0; row < shape.length; row++)
        {
            for (int col = 0; col < shape[row].length; col++)
            {
                rotatedShape[col][shape.length - 1 - row] = shape[row][col];
            }
        }
        shape = rotatedShape;
    }
    public Piece clone()
    {
        Piece newPiece = new Piece(this.type, this.row, this.col);
        newPiece.shape = this.shape;
        return newPiece;
    }

    public int getCol()
    {
        return col;
    }
    public int[][] getShape()
    {
        return shape;
    }

    public void setRow(int row)
    {
        this.row = row;
    }
    public void setCol(int col)
    {
        this.col = col;
    }

    public boolean isFilled(int row, int col)
    {
        if (row >= 0 && row < shape.length && col >= 0 && col < shape[row].length)
        {
            return shape[row][col] == 1;
        }
        else
        {
            return false;
        }
    }
    public static Piece randomPiece()
    {
        PieceType[] types = PieceType.values();
        int randomIndex = (int) (Math.random() * types.length);
        PieceType randomType = types[randomIndex];
        return new Piece(randomType, 0, 4);
    }
//    public static Piece testingPiece()
//    {
//        return new Piece(PieceType.TEST, 0, 4);
//    }

//    public static void printShape(int[][] shape) {
//        for (int row = 0; row < shape.length; row++) {
//            for (int col = 0; col < shape[row].length; col++) {
//                if(shape[row][col] == 1)
//                    System.out.print("X");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }
}