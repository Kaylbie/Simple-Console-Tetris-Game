package command;
import control.PieceControl;
public class MoveLeftCommand implements Command {
    private PieceControl pieceControl;

    public MoveLeftCommand(PieceControl pieceControl) {
        this.pieceControl = pieceControl;
    }
    @Override
    public void execute() {
        pieceControl.movePieceLeft();
    }
}
