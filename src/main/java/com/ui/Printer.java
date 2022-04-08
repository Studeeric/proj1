package com.ui;

public class Printer implements IPrinter{

    @Override
    public void print(String in) {
        System.out.println(in);        
    }
}
class FakePrinter implements IPrinter{
    String lastIn;
    
    @Override
    public void print(String in) {
        this.lastIn = in;
        
    }

}



interface IPrinter{
    void print(String in);
}
