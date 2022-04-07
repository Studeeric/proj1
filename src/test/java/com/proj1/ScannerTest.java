package com.proj1;

import com.logic.IScanner;

class ScannerTest implements IScanner{

  int intValue;
  String stringValue;

  public void setInt(int x){
      this.intValue = x;
  }

  public void setString(String x){
      this.stringValue = x;
  }

  @Override
  public int nextInt() {
      return intValue;
  }

  @Override
  public String nextLine() {
      return stringValue;
  }
}
