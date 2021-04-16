package com.restapisample;

import static com.restapisample.Desp.*;

import java.util.Arrays;

public enum Movement {
  LEFT("left", BACKWARD, ZERO, true),
  RIGHT("right", FORWARD, ZERO, true),
  UP("up", ZERO, BACKWARD, false),
  DOWN("down", ZERO, FORWARD, false),
  ;


  private final String move;

  private final Desp despX;

  private final Desp despY;

  private final boolean swap;

  Movement(String move, Desp despX, Desp despY, boolean swap) {
    this.move = move;
    this.despX = despX;
    this.despY = despY;
    this.swap = swap;
  }

  public static Movement from(String move) {
    return Arrays.stream(Movement.values())
        .filter(movement -> movement.getMove().equals(move))
        .findFirst()
        .orElse(null);
  }

  public String getMove() {
    return move;
  }

  public Desp getDespX() {
    return despX;
  }

  public Desp getDespY() {
    return despY;
  }

  public boolean isSwap() {
    return swap;
  }
}
