import java.util.Scanner;

public class Tetris
{
    private Board board;
    private int score;
    private static boolean isGameOver;
    private Scanner scanner;

    public Tetris()
    {
        board = new Board();
        score = 0;
        scanner = new Scanner(System.in);
    }
    public void startGame()
    {
        renderOutput();
        while (!isGameOver)
        {
            processInput();
            updateGame();
            renderOutput();
            //delay();
        }
        System.out.println("game over! score: " + score);
    }

    private void processInput()
    {
        System.out.println("commands (A-left/D-right/S-down/W-rotate): ");
        String command = scanner.nextLine();
        processCommand(command);
    }
    private void processCommand(String command)
    {
        switch (command.toUpperCase())
        {
            case "A":
                board.movePieceLeft();
                break;
            case "D":
                board.movePieceRight();
                break;
            case "S":
                board.movePieceDown();
                break;
            case "W":
                board.rotatePiece();
                break;
            default:
                System.out.println("wrong command");
                break;
        }
    }
    private void updateGame()
    {
        int linesCleared = board.clearCompletedLines();
        score += calculateScore(linesCleared);
    }
    private int calculateScore(int linesCleared)
    {
        switch (linesCleared)
        {
            case 1: return 40;
            case 2: return 100;
            case 3: return 300;
            case 4: return 1200;
            default: return 0;
        }
    }
    private void renderOutput()
    {
        clearConsole();
        board.printBoard();
        System.out.println("score: " + score);
    }

    private void delay()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    private void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args)
    {
        Tetris game = new Tetris();
        game.startGame();
    }
    public static void setGameOver(boolean gameOver)
    {
        isGameOver = gameOver;
    }
}
