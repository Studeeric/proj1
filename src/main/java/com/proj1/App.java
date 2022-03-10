package com.proj1; import java.util.Scanner; import java.io.IOException;


public class App {
    public static void main( String[] args){
        mainMenu();
    }

    public static void mainMenu() {
        clrscr();
        printMenu();
        Scanner james = new Scanner(System.in);
        int chooseAction = james.nextInt();
        try{
            switch (chooseAction){
                case (1):
                    System.out.println("test1");
                    mainMenu();
                case(2):
                    System.out.println("test2");
                    mainMenu();
                case(3):
                    System.out.println("test3");
                    mainMenu();
                case(4):
                    System.out.println("test4");
                    mainMenu();
                case(5):
                    System.out.println("test5");
                    mainMenu();
                case(6):
                    System.out.println("test6");
                    mainMenu();
                case(7):
                    System.out.println("test7");
                    mainMenu();
                case(8):
                    System.out.println("test8");
                    mainMenu();
                case(0):
                    System.out.println("exiting now.");
                    break;
                default:
                    System.out.println("No option found, please choose a listed option");
                    mainMenu();
            }
        }finally {}
        james.close();

        
    }

    public static void printMenu() {
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor test?");
        System.out.println("7) Welke examens heeft student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Exit");
    }

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}


