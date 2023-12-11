package controls;

import board.Board;
import commands.*;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class GameInput {
    private Scanner scanner;
    private Board board;
    private Map<String, Command> commandMap;

    public GameInput(Board board) {
        this.scanner = new Scanner(System.in);
        this.board = board;
        this.commandMap = new HashMap<>();

        setupCommands();
    }
    private void setupCommands() {
        commandMap.put("A", new MoveLeftCommand(board.getPieceControl()));
        commandMap.put("D", new MoveRightCommand(board.getPieceControl()));
        commandMap.put("S", new MoveDownCommand(board.getPieceControl()));
        commandMap.put("W", new RotateCommand(board.getPieceControl()));
    }

    public void processInput() {
        String commandKey = scanner.nextLine().toUpperCase();
        Command command = commandMap.get(commandKey);
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Invalid command");
        }
    }

}
