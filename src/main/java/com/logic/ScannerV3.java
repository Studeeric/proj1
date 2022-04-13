package com.logic;

import java.util.Scanner;

public class ScannerV3 implements IScanner{
    Scanner scanner = new Scanner(System.in);

    public ScannerV3(){} //private constructor means no objects can be made of this class

    @Override
    public int nextInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } 
            catch (NumberFormatException e) {
                System.out.println("Voer enkel cijfers in.");
            }
        }
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }
}

class FakeScanner implements IScanner{
    int intValue;
    String stringValue;

    private FakeScanner(){} //private constructor means no objects can be made of this class

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
