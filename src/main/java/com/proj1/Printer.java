package com.proj1;

public class Printer implements IPrinter {

    @Override
    public void print(String in) {
        System.out.println(in);
        
    }
 
    
}   

abstract class FakePrinter implements IPrinter{
    public String lastoutput;
    @Override
    public void print(String in) {
        this.lastoutput = in;
    }

}

interface IPrinter{
    public void print(String in);

}
