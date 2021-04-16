package com.restapisample;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import org.springframework.util.StringUtils;

public class Board {

  private Map<CursorPosition, String> cards = new HashMap<>();

  public Board(String[][] fighters) {
    for (int i=0; i<fighters.length; i++) {
      for (int j=0; j<fighters[i].length; j++) {
        CursorPosition cursorPosition = new CursorPosition(j, i);
        cards.put(cursorPosition, fighters[i][j]);
      }
    }
  }

  public static Board from(String[][] fighters) {
    return new Board(fighters);
  }

  public String getFighter(AtomicReference<CursorPosition> currentCursorPosition) {
    return this.cards.get(currentCursorPosition);
  }


  public int getWidth() {
    return this.getDimension(CursorPosition::getX);
  }

  public int getHeight() {
    return this.getDimension(CursorPosition::getY);
  }

  private int getDimension(Function<CursorPosition, Integer> getter) {
    return this.cards.keySet().stream().map(getter).max(Integer::compareTo).orElse(0) + 1;
  }

  public String get(CursorPosition cursorPosition) {
    return this.cards.get(cursorPosition);
  }

  public String move(AtomicReference<CursorPosition> currentCursorPosition, String move) {
    return this.getFighter(this.move(currentCursorPosition, Movement.from(move)));
  }

  private AtomicReference<CursorPosition> move(AtomicReference<CursorPosition> currentCursorPosition, Movement movement) {
    final AtomicReference<CursorPosition> nextCursorPosition = currentCursorPosition.get().apply(movement, this);
    if (isValid(nextCursorPosition)) {
      return nextCursorPosition;
    }
    if (movement.isSwap()) {
      return move(nextCursorPosition, movement);
    }
    return currentCursorPosition;
  }

  private boolean isValid(AtomicReference<CursorPosition> currentCursorPosition) {
    return !StringUtils.isEmpty(this.getFighter(currentCursorPosition));
  }
}
