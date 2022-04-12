package com.ui;

public class exManagerUI extends UI{
    private exManagerUI(){
    }

    /* exManagerMenu */
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

    /* exNewExam */
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

    /* exRemoveExam*/
    public static void printExRemoveMenu(String examName, String examCategory) {
        System.out.println("Weet u zeker dat u het volgende examen wil verwijderen\n" + examName + " - " +examCategory+"?");
        System.out.println("Y\\N");
        
    }
    public static void printExRemoveReact(boolean positive) {
        if(positive)
            System.out.println("Examen verwijderd.\nReturning to examen menu...");
        else
            System.out.println("Examen verwijderen geannuleerd.\n Returning to examen menu...");
        
    }
    public static void printExRemoveDefaultError() {
        System.out.println("Kies tussen: Yes(Y) of No(N)");
    }

    /* exEditExam */
    public static void printExEditMainMenu() {
        System.out.println("""
                    1) Add a question
                    2) Remove a question
                    3) Edit a question
                    0) Exit""");
    }
    public static void printExEditQuestionEditQuestion(boolean question) {
        if(question)
            System.out.println("Welke vraag wil u aanpassen?");
        else
            System.out.println("Welke regel wil u aanpassen?");
    }
    public static void printExEditQuestionList(int i, String prompt) {
        System.out.println((i+1)+") "+ prompt);
        
    }
    public static void printExEditQuestionList() {
        System.out.println("0) Exit");
    }
    public static void printExEditQuestionEditMenu(String old_line ) {
        System.out.println("Oude regel:");
        System.out.println(old_line);
        System.out.println("Nieuwe regel:");
    }
    public static void printExEditQuestionEditConfirm() {
        System.out.println("Regel aangepast");
    }

    /* exAddQuestion */
    public static void printExAddQMenu(int size) {
        System.out.println("The selected exam has currently "+size+" Questions\n");
        System.out.println("""
            Please choose an option:
            1) Make a new question
            2) View current questions
            0) Return to menu""");
    }
    public static void printExAddQLoop(boolean vraag, String content,int counter) {
        if(vraag)
            System.out.println("Vraag: " + counter);
        else
            System.out.println(content);
    }
}
