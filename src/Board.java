public class Board
{
    public int width = 10;
    public int height = 10;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    private int[][] grid;
    private Piece currentPiece;

    public Board()
    {
        grid = new int[height][width];
        //spawnTestingPiece();
        spawnNewPiece();
    }

    private void spawnNewPiece()
    {
        currentPiece = Piece.randomPiece();
        currentPiece.setRow(0);
        currentPiece.setCol(width / 2 - currentPiece.getShape()[0].length / 2);

        if (!canPlacePiece(currentPiece))
        {
            Tetris.setGameOver(true);
        }
    }
//    private void spawnTestingPiece()
//    {
//        currentPiece = Piece.testingPiece();
//        currentPiece.setRow(0);
//        currentPiece.setCol(width / 2 - currentPiece.getShape()[0].length / 2);
//    }
    private boolean canPlacePiece(Piece piece)
    {
        return canMove(piece, piece.getRow(), piece.getCol());
    }

    public void movePieceDown()
    {
        if (canMove(currentPiece, currentPiece.getRow() + 1, currentPiece.getCol()))
        {
            currentPiece.moveDown();
        }
        else
        {
            fixToGrid(currentPiece);
            //spawnTestingPiece();
            spawnNewPiece();
        }
    }

    public boolean canMove(Piece piece, int newRow, int newCol)
    {
        int[][] shape = piece.getShape();

        for (int row = 0; row < shape.length; row++)
        {
            for (int col = 0; col < shape[row].length; col++)
            {
                if (shape[row][col] != 0)
                {
                    int gridRow = newRow + row;
                    int gridCol = newCol + col;

                    if (gridRow < 0 || gridRow >= height || gridCol < 0 || gridCol >= width)
                    {
                        return false;
                    }

                    if (grid[gridRow][gridCol] != 0)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void fixToGrid(Piece piece)
    {
        for (int row = 0; row < piece.getShape().length; row++)
        {
            for (int col = 0; col < piece.getShape()[row].length; col++)
            {
                if (piece.getShape()[row][col] != 0)
                {
                    grid[piece.getRow() + row][piece.getCol() + col] = 1;
                }
            }
        }
    }
    public int clearCompletedLines()
    {
        int linesCleared = 0;
        for (int row = 0; row < height; row++)
        {
            if (isLineComplete(row))
            {
                clearLine(row);
                linesCleared++;
            }
        }
        return linesCleared;
    }

    public boolean isLineComplete(int row)
    {
        for (int col = 0; col < width; col++)
        {
            if (grid[row][col] == 0)
            {
                return false;
            }
        }
        return true;
    }

    public void clearLine(int line)
    {
        for (int row = line; row > 0; row--)
        {
            System.arraycopy(grid[row - 1], 0, grid[row], 0, width);
        }
        grid[0] = new int[width];
    }

    public void printBoard()
    {
        System.out.println("+" + "-".repeat(width) + "+");

        for (int row = 0; row < height; row++)
        {
            System.out.print("|");

            for (int col = 0; col < width; col++)
            {
                if (grid[row][col] == 1)
                {
                    System.out.print(ANSI_RED+"X"+ANSI_RESET);
                }
                else
                {
                    if (currentPiece != null && currentPiece.isFilled(row - currentPiece.getRow(), col - currentPiece.getCol()))
                    {
                        System.out.print(ANSI_RED+"X"+ANSI_RESET);
                    }
                    else
                    {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println("|");
        }

        System.out.println("+" + "-".repeat(width) + "+");
    }

    public void movePieceLeft()
    {
        if (canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol() - 1))
        {
            currentPiece.moveLeft();
        }
    }

    public void movePieceRight()
    {
        if (canMove(currentPiece, currentPiece.getRow(), currentPiece.getCol() + 1))
        {
            currentPiece.moveRight();
        }
    }
    public void rotatePiece()
    {
        Piece testPiece = currentPiece.clone();
        testPiece.rotate();
        if (canMove(testPiece, testPiece.getRow(), testPiece.getCol()))
        {
            currentPiece.rotate();
        }
    }
}
