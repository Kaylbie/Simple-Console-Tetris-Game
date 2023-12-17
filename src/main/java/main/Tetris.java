package main;

import board.Board;
import board.BoardRender;
import control.GameInput;

public class Tetris {
    private Board board;
    private int score;
    private static boolean isGameOver;
    private GameInput gameinput;
    private BoardRender renderer;
    public static void main(String[] args) {
        Tetris game = new Tetris();
        game.startGame();
    }
    public Tetris() {
        board = new Board();
        score = 0;
        gameinput = new GameInput(board);
        renderer=new BoardRender();
    }
    public void startGame() {
        while (!isGameOver) {
            renderer.printGameStatus(board, score);
            gameinput.processInput();
            updateScore();
        }
        endGame();
    }
    private void updateScore() {
        int linesCleared = board.clearCompletedLines();
        score += calculateScore(linesCleared);
    }
    private int calculateScore(int linesCleared) {
        switch (linesCleared) {
            case 1:
                return 40;
            case 2:
                return 100;
            case 3:
                return 300;
            case 4:
                return 1200;
            default:
                return 0;
        }
    }
    private void endGame() {
        renderer.printGameOver(score);
    }
    public static void setGameOver() {
        isGameOver = true;
    }
}