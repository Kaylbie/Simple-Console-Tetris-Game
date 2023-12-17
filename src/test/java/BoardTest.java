import board.Board;
import org.junit.Test;
import pieces.GamePiece;
import pieces.PieceI;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testCanMove() {
        Board board = new Board();
        GamePiece piece = new PieceI(0, 4);

        assertTrue("Can move down", board.canMove(piece, 1, 4));
        piece.setRow(board.getHeight() - 1);
        assertFalse("Can't move down", board.canMove(piece, board.getHeight(), 4));

    }
    @Test
    public void testClearCompletedLines() {
        Board board = new Board();
        int width = board.getWidth();

        for (int col = 0; col < width; col++) {
            board.getGrid()[board.getHeight() - 1][col] = 1;
        }

        int clearedLines = board.clearCompletedLines();
        assertEquals("One line should be cleared", 1, clearedLines);


        for (int row = 0; row < board.getHeight(); row++) {
            for (int col = 0; col < width; col++) {
                assertEquals("Grid should be empty at row " + row, 0, board.getGrid()[row][col]);
            }
        }
    }
}