package com.restapisample;

import org.springframework.util.StringUtils;

public class Board {

    private String[][] fighters;

    private CursorPosition cursorPosition;

    public Board(String[][] fighters, CursorPosition cursorPosition) {
        this.fighters = fighters;
        this.cursorPosition = cursorPosition;
    }

    public String[][] getFighters() {
        return fighters;
    }

    public void setFighters(String[][] fighters) {
        this.fighters = fighters;
    }

    public CursorPosition getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(CursorPosition cursorPosition) {
        this.cursorPosition = cursorPosition;
    }

    public static Board from(String[][] fighters, CursorPosition cursorPosition) {
        return new Board(fighters, cursorPosition);
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

    public String moveLeft(CursorPosition cursorPosition) {
        cursorPosition.left();
        if (cursorPosition.getPositionX() < getLeftLimit()){
            cursorPosition.setPositionX(getRightLimit());
        }
        if (StringUtils.isEmpty(getFighter(cursorPosition))) {
            return moveLeft(cursorPosition);
        }

        return getFighter(cursorPosition);
    }

    public String moveRight(CursorPosition cursorPosition) {
        cursorPosition.right();
        if (cursorPosition.getPositionX() > getRightLimit()){
            cursorPosition.setPositionX(getLeftLimit());
        }
        if (StringUtils.isEmpty(getFighter(cursorPosition))) {
            return moveRight(cursorPosition);
        }

        return getFighter(cursorPosition);
    }

    public String moveUp(CursorPosition cursorPosition) {
        cursorPosition.up();
        if (cursorPosition.getPositionY() < getTopLimit()){
            cursorPosition.setPositionY(getTopLimit());
        }
        if (StringUtils.isEmpty(getFighter(cursorPosition))) {
            cursorPosition.down();
            return getFighter(cursorPosition);
        }

        return getFighter(cursorPosition);
    }

    public String moveDown(CursorPosition cursorPosition) {
        cursorPosition.down();
        if (cursorPosition.getPositionY() > getBottomLimit()){
            cursorPosition.setPositionY(getBottomLimit());
        }
        if (StringUtils.isEmpty(getFighter(cursorPosition))) {
            cursorPosition.up();
            return getFighter(cursorPosition);
        }

        return getFighter(cursorPosition);
    }
}
