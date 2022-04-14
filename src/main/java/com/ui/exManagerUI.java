package com.ui;
import java.util.ArrayList;

public class exManagerUI extends UI{

    private exManagerUI(){}  //private constructor means no objects can be made of this class

    // exManagerMenu
    public static void printExManagerMenu() {
        clearScreen();
        System.out.println(
        "Welcome to the KekCorp© Exam Manager. \n" +
        "Please choose an option:\n" +
        ANSI_CYAN + "1) " + ANSI_RESET + "Add a new Exam\n" +
        ANSI_CYAN + "2) " + ANSI_RESET + "Remove a Exam\n" +
        ANSI_CYAN + "3) " + ANSI_RESET + "Edit Exam Questions\n" +
        ANSI_RED +  "0) Exit" + ANSI_RESET);
    }

    public static void printExReturnMainMenu(boolean Default) {
        if(Default)
            System.out.println("Please choose a listed option...");
        else
            System.out.println("Returning to main menu...");
    }

    // exNewExam
    public static void printExExamInput(boolean name) {
        if(name)
            System.out.println("Geef de naam van het examen:");
        else
            System.out.println("Geef de categorie van het examen:");
    }
    
    public static void printExAddOptions(boolean fastTrack) {
        if(fastTrack)
            System.out.println("Examen toegevoegd, wil u gelijk vragen toevoegen?\n1)Ja\n0)Nee");
        else
            System.out.println("Examen toegevoegd!\nReturning to main menu...");
    }
    public static void printExExamInputError(boolean type) {
        if(type)
            System.out.println("Voer geen lege naam in");
        else
            System.out.println("Voer geen lege vraag in");
        
    }

    // exRemoveExam
    public static void printExRemoveMenu(String examName, String examCategory) {
        System.out.println("Weet u zeker dat u het volgende examen wil verwijderen\n" + examName + " - " +examCategory+"?");
        System.out.println(ANSI_RED + "1) Ja, verwijder dit examen " + examName + ANSI_RESET);
        System.out.println(ANSI_GREEN + "0) Nee, keer terug naar het hoofdmenu" + ANSI_RESET);
    }

    public static void printExRemoveReact(boolean positive) {
        if(positive)
            System.out.println("Examen verwijderd.\nReturning to examen menu...");
        else
            System.out.println("Examen verwijderen geannuleerd.\n Returning to examen menu...");
    }

    public static void printExRemoveDefaultError() {
        System.out.println("Kies tussen: 1 of 0");
    }

    // exEditExam
    public static void printExEditMainMenu() {
        System.out.println(
            ANSI_CYAN + "1) " + ANSI_RESET + "Add a question \n" +
            ANSI_CYAN + "2) " + ANSI_RESET + "Remove a question \n" +
            ANSI_CYAN + "3) " + ANSI_RESET + "Edit a question \n" +
            ANSI_RED + "0) Exit" + ANSI_RESET);
    }

    public static void printExEditQuestionEditQuestion(boolean question) {
        if(question)
            System.out.println("Van welk examen wil u een vraag aanpassen?");
        else
            System.out.println("Welke regel wil u aanpassen?");
    }

    public static void printExEditQuestionList(int i, String prompt) {
        System.out.println(ANSI_CYAN + (i+1) +") " + ANSI_RESET + prompt);   
    }

    public static void printExEditQuestionList() {
        System.out.println(ANSI_RED + "0) Exit" + ANSI_RESET);
    }

    public static void printExEditQuestionEditMenu(String old_line ) {
        System.out.println("Oude regel:");
        System.out.println(old_line);
        System.out.println("Nieuwe regel:");
    }

    public static void printExEditQuestionEditConfirm() {
        System.out.println("Regel aangepast");
    }

    // exAddQuestion
    public static void printExAddQMenu(int size) {
        System.out.println("The selected exam has currently "+size+" Questions\n");
        System.out.println(
            "Please choose an option:\n" + 
            ANSI_CYAN + "1) " + ANSI_RESET + " Make a new question\n" +
            ANSI_CYAN + "2) " + ANSI_RESET + " View current questions\n" +
            ANSI_RED + "0) " + ANSI_RESET + " Return to menu");
    }

    public static void printExAddQLoop(boolean vraag, String content, int counter) {
        if(vraag)
            System.out.println("Vraag: " + counter);
        else
            System.out.println(content);
    }
    public static void printExAddQuestVars(String text, boolean emptyline) {
        System.out.println(text);
        if(emptyline)
            System.out.println();
    }

    /* exRemoveQuestion */
    public static void prinExRemoveQuestAsk(int counter,String prompt, boolean loop) {
        if(loop)
            System.out.println((counter+1)+") "+ prompt);
        else
            System.out.println("Welke vraag wil u verwijderen?");
    }

    public static void printExRemoveQuestConfirm(String questName) {
        System.out.println("Weet u zeker dat u deze vraag wil verwijderen\n" + questName);
        System.out.println(ANSI_RED+"1) Ja, verwijder deze vraag" + questName+ANSI_RESET);
        System.out.println(ANSI_GREEN+"0) Nee, keer terug naar het hoofdmenu"+ANSI_RESET);
    }

    public static void printExRemoveQuestReturn(boolean confirmed) {
        if(confirmed)
            System.out.println("Vraag verwijderd.\nReturning to menu...");
        else
            System.out.println("Vraag verwijderen geannuleerd.\nReturning to menu...");
    }

    /* exGetQuestCont */
    public static void printExGetQuestCt(int line) {
        if(line ==1 )
            System.out.println("Voer de vraag in:");
        else if(line == 2)
            System.out.println("Enter a option & press return to confirm. Press 0 to stop adding options");
        else if (line == 3)
            System.out.println("Welke optie is het juiste antwoord?");
    }

    /* Misc */
    public static void exPrintQuestArray(ArrayList<String> contents,boolean numbered) {
        System.out.println("Vraag x:");
        System.out.println();
        for(int i=0;i<contents.size();i++){
            if(numbered){
                System.out.println((i+1)+" "+contents.get(i));
            }
            else{
            System.out.println(contents.get(i));
            }
        }
    }
    public static void exPrintNewQuestArray(ArrayList<String> contents,boolean numbered) {
        System.out.println();
        for(int i=1;i<contents.size();i++){
            if(numbered){
                System.out.println((i)+" "+contents.get(i));
            }
            else{
            System.out.println(contents.get(i));
            }
        }
    }
}
