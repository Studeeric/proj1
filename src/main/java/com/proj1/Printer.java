package com.proj1;

public class Printer implements IPrinter{

    @Override
    public void print(String in) {
        System.out.println(in);        
    }
}



interface IPrinter{
    void print(String in);
}
