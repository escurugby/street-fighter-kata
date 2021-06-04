package com.restapisample;

public class Stat {

    private int value;

    public Stat(int value) {
        if (value < 1 || value > 10) {
            throw new IncorrectStatException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
