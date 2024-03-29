package command;
import control.PieceControl;
public class MoveRightCommand implements Command {
    private PieceControl pieceControl;

    public MoveRightCommand(PieceControl pieceControl) {
        this.pieceControl = pieceControl;
    }

    @Override
    public void execute() {
        pieceControl.movePieceRight();
    }
}
