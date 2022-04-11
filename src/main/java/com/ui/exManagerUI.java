package com.ui;

public class exManagerUI extends UI{
    private exManagerUI(){
    }

    public static void printExManagerMenu() {
        clearScreen();
        System.out.println("""
        Welcome to the KekCorp© Exam Manager.
        Please choose an option:
        1) Add a new Exam
        2) Remove a Exam
        3) Edit Exam Questions
        0) Exit""");
    }
    public static void printExReturnMainMenu(boolean Default) {
        if(Default)
            System.out.println("Please choose a listed option...");
        else
            System.out.println("Returning to main menu...");
    }
    public static void printExExamInput(boolean name) {
        if(name)
            System.out.println("Geef de naam van het examen:");
        else
            System.out.println("Geef de categorie van het examen:");
        
    }
    public static void printExAddOptions(boolean fastTrack) {
        if(fastTrack)
            System.out.println("Examen toegevoegd, wil u gelijk vragen toevoegen?\n1)Ja\n2)Nee");
        else
            System.out.println("Examen toegevoegd!\nReturning to main menu...");
    }
    public static void printExRemoveMenu(String examName, String examCategory) {
        System.out.println("Weet u zeker dat u het volgende examen wil verwijderen\n" + examName + " - " +examCategory+"?");
        System.out.println("Y\\N");
        
    }
}
