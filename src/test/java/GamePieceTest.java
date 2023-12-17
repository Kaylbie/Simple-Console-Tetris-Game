import static org.junit.Assert.*;
import org.junit.Test;
import pieces.GamePiece;
import pieces.PieceI;

public class GamePieceTest {
    @Test
    public void testPieceRotation() {
        GamePiece piece = new PieceI(0, 0);
        int[][] originalShape = piece.getShape();
        piece.rotate();
        int[][] rotatedShape = piece.getShape();
        assertNotEquals(originalShape, rotatedShape);
    }
}
