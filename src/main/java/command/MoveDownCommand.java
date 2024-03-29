package command;
import control.PieceControl;

public class MoveDownCommand implements Command {
    private PieceControl pieceControl;

    public MoveDownCommand(PieceControl pieceControl) {
        this.pieceControl = pieceControl;
    }

    @Override
    public void execute() {
        pieceControl.movePieceDown();
    }
}
