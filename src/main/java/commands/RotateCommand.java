package commands;
import controls.PieceControl;
public class RotateCommand implements Command {
    private PieceControl pieceControl;

    public RotateCommand(PieceControl pieceControl) {
        this.pieceControl = pieceControl;
    }

    @Override
    public void execute() {
        pieceControl.rotatePiece();
    }
}
