package com.ui;

public class Printer implements IPrinter{

    @Override
    public void print(String in) {
        System.out.println(in);        
    }
}



interface IPrinter{
    void print(String in);
}
