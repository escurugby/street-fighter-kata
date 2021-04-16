package com.restapisample;

public class Board {

    private String[][] fighters;

    public Board(String[][] fighters) {
        this.fighters = fighters;
    }

    public static Board from(String[][] fighters) {
        return new Board(fighters);
    }

    public int getWidth() {
        return this.fighters[0].length;
    }

    public int getHeight() {
        return this.fighters.length;
    }

    public int getRightLimit() {
        return this.getWidth()-1;
    }

    public int getLeftLimit() {
        return 0;
    }

    public int getBottomLimit() {
        return this.getHeight()-1;
    }

    public int getTopLimit() {
        return 0;
    }

    public String getFighter(CursorPosition cursorPosition) {
        return fighters[cursorPosition.getPositionY()][cursorPosition.getPositionX()];
    }
}
