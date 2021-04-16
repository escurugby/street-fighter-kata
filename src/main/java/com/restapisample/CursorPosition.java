package com.restapisample;

public class CursorPosition {

    private int positionX;
    private int positionY;

    public CursorPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "CursorPosition{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    public static CursorPosition from(int[] position) {
        return new CursorPosition(position[1], position[0]);
    }

    public CursorPosition clone() {
        return new CursorPosition(this.positionX, this.positionY);
    }

}
