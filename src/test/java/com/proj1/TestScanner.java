package com.proj1;

import java.util.ArrayList;

import com.logic.IScanner;

class TestScanner implements IScanner{

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

class RepeatingTestScanner extends TestScanner{
    ArrayList<String> sendlist = new ArrayList<>();
    int counter = 0;

    @Override
    public String nextLine() {
        this.stringValue = sendlist.get(counter);
        counter++;
        return super.nextLine();
    }

    public void resetRepeatScanner() {
        this.sendlist.clear();
        this.counter = 0;
    }
    
}
