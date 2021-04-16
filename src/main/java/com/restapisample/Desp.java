package com.restapisample;

public enum Desp {
  BACKWARD(-1),
  ZERO(0),
  FORWARD(1);

  private final int desp;

  Desp(int desp) {
    this.desp = desp;
  }

  public int getDesp() {
    return desp;
  }
}
