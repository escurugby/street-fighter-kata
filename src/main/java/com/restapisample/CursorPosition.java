package com.restapisample;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class CursorPosition {

  private int x;
  private int y;

  public CursorPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public static AtomicReference<CursorPosition> from(int[] position) {
    if (position == null || position.length != 2) {
      throw new IllegalArgumentException("position no es correcto");
    }
    return new AtomicReference<>(new CursorPosition(position[1], position[0]));
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public AtomicReference<CursorPosition> apply(Movement movement, Board board) {
    int x = this.x + movement.getDespX().getDesp();
    x = correct(x, movement.isSwap(), board.getWidth());
    int y = this.y + movement.getDespY().getDesp();
    y = correct(y, movement.isSwap(), board.getHeight());

    return new AtomicReference<>(new CursorPosition(x, y));
  }

  private int correct(int coord, boolean swap, int size) {
    if(coord > (size-1)) {
      return swap ? 0 : (size-1);
    }
    if (coord < 0) {
      return swap ? (size-1) : 0;
    }

    return coord;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CursorPosition that = (CursorPosition) o;
    return x == that.x &&
        y == that.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public String toString() {
    return "CursorPosition{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
