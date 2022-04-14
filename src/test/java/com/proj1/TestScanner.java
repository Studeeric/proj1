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
    ArrayList<Integer> intlist = new ArrayList<>();
    int counter = 0;
    int intCounter = 0;

    @Override
    public String nextLine() {
        this.stringValue = sendlist.get(counter);
        if(counter < sendlist.size()-1)
            counter++;
        return super.nextLine();
    }
    @Override
    public int nextInt() {
        this.intValue = intlist.get(intCounter);
        if(intCounter < intlist.size()-1)
            intCounter++;
        return super.nextInt();
    }

    public void clear() {
        this.sendlist.clear();
        this.counter = 0;
        this.intCounter = 0;
        this.intlist.clear();
    }
}
