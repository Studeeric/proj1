package com.logic;

public interface IScanner {
  int nextInt();
  String nextLine();
}

class RealScanner implements IScanner {

  public RealScanner() {
  }

  @Override
  public int nextInt() {
    return 0;
  }

  @Override
  public String nextLine() {
    return null;
  }

}