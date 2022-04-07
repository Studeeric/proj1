package com.proj1;

import java.util.Scanner;

interface IScanner{
    int nextInt();
    String nextLine();
}

public class ScannerV3 implements IScanner{
    Scanner scanner = new Scanner(System.in);

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
