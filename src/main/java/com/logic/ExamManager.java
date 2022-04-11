package com.logic; import java.util.ArrayList;
import com.ui.UI;


/*
=======Class Explanation=======
This class manages creating, deleting & editing exams and the questions in them.
Thanks for coming to my TED talk.
*/

abstract public class ExamManager {

    public static void exManagerMenu(IScanner scanner) {
        exManagerLoop: while (true) {
            printExManagerMenu();
            String userChoiceExManager = scanner.nextLine();
            switch(userChoiceExManager){
                case("1"):
                    exNewExam(scanner);
                    break;
                case("2"):
                    exRemoveExam(scanner, exChooseExamIndex(scanner,false));
                    break;
                case("3"):
                    exEditExam(scanner);
                    break;
                case("0"):
                    UI.clearScreen();
                    System.out.println("Returning to main menu...");
                    Debug.wait(1,true);
                    break exManagerLoop;
                default:
                    System.out.println("Please choose a listed option...");
                    Debug.wait(2,true);
                    break;
            }
        }
    }

    public static void printExManagerMenu() {
        UI.clearScreen();
        System.out.println("""
        Welcome to the KekCorp© Exam Manager.
        Please choose an option:
        1) Add a new Exam
        2) Remove a Exam
        3) Edit Exam Questions
        0) Exit""");

    }

    //Action methods
    public static void exNewExam(IScanner scanner) {
        System.out.println("Geef de naam van het examen:");
        String newExName = scanner.nextLine();
        System.out.println("Geef de categorie van het examen:");
        String newExCat = scanner.nextLine();
        Exam exManagerCreated = new Exam(newExName, newExCat);
        System.out.println("Examen toegevoegd, wil u gelijk vragen toevoegen?\n1)Ja\n2)Nee");
        if(scanner.nextLine().equals("1")){
            exAddQuestion(exManagerCreated,scanner);
        }
        System.out.println("Examen toegevoegd!\nReturning to main menu...");
        Debug.wait(2,true);
    }

    
    public static void exRemoveExam(IScanner scanner,int exToBeRemoved) {
        UI.clearScreen();
        System.out.println("Weet u zeker dat u het volgende examen wil verwijderen\n" + Exam.examList.get(exToBeRemoved).getName() + " - " +Exam.examList.get(exToBeRemoved).getCategory()+"?");
        System.out.println("Y\\N");
        exRemoveLoop: while (true){
            switch(scanner.nextLine()){
                case("y"):
                case("Y"):
                case("yes"):
                case("Yes"):
                case("j"):
                case("J"):
                case("ja"):
                case("Ja"):
                    Exam.examList.remove(exToBeRemoved);
                    System.out.println("Examen verwijderd.\nReturning to examen menu...");
                    break exRemoveLoop;
                case("n"):
                case("N"):
                case("no"):
                case("No"):
                case("nee"):
                case("Nee"):
                    System.out.println("Examen verwijderen geannuleerd.\n Returning to examen menu...");
                    break exRemoveLoop;
                default:
                System.out.println("Kies tussen: Yes(Y) of No(N)");
                    break;

            }
        }
        
    }

    public static void exEditExam(IScanner scanner) {
        exEditMainLoop: while(true){
            System.out.println("Kies een examen om aan te passen");
            int exIndex = exChooseExamIndex(scanner,true);
            if(exIndex != -1){
                
                Exam exActualExam = Exam.examList.get(exIndex);
                exEditSubLoop: while (true){
                    System.out.println("""
                    1) Add a question
                    2) Remove a question
                    3) Edit a question
                    0) Exit""");

                    switch(scanner.nextLine()){
                        case("1"):
                            exAddQuestion(exActualExam, scanner);
                            break;
                        case("2"):
                            exRemoveQuestion(exActualExam, scanner);
                            break;
                        case("3"):
                            System.out.println("Welke vraag wil u aanpassen?");
                            for(int i = 0; i< exActualExam.questionList.size();i++){
                                System.out.println((i+1)+") "+ exActualExam.questionList.get(i).questionContents.get(0));
                            }
                            System.out.println("0) Exit");
                            int exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
                            if(exUserEditChoice != -1){
                                Question exChosenQuest = exActualExam.questionList.get(exUserEditChoice);
                                UI.clearScreen();
                                exPrintQuestArray(exChosenQuest.questionContents, true);
                                System.out.println("Welke regel wil u aanpassen?");
                                exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
                                UI.clearScreen();
                                System.out.println("Oude regel:");
                                System.out.println(exChosenQuest.questionContents.get(exUserEditChoice));
                                System.out.println("Nieuwe regel:");
                                exChosenQuest.questionContents.set(exUserEditChoice, scanner.nextLine());
                                System.out.println("Regel aangepast");
                                App.pauseMenu(scanner);
                            }
                            break;
                        case("0"):
                            break exEditSubLoop;
                            
                        default:
                            break;
                    }
                }
            }
            else{break exEditMainLoop;}

        }
        
    }

    

    //Support methods
    public static void exAddQuestion(Exam exam,IScanner scanner) {
        exAddQuestLoop1: while(true){
            UI.clearScreen();
            System.out.println("The selected exam has currently "+exam.getQuestionList().size()+" Questions\n");
            System.out.println("""
                Please choose an option:
                1) Make a new question
                2) View current questions
                0) Return to menu""");
            switch (scanner.nextLine()) {
                case ("1"):
                    exam.addQuestion(new Question(exGetQuestCont(scanner)));
                    break;
                case("2"):
                    int counter = 1;
                    for(Question question : exam.questionList){
                        System.out.println("Vraag: " + counter);
                        for(String content : question.questionContents){
                            System.out.println(content);
                        }
                        counter++;
                        System.out.println();
                    }
                    App.pauseMenu(scanner);
                    break;
                case ("0"):
                    break exAddQuestLoop1;
                default:
                    break;
            }
        }
    }

    public static void exRemoveQuestion(Exam exActualExam, IScanner scanner) {
        System.out.println("Welke vraag wil u verwijderen?");
        for(int i = 0; i< exActualExam.questionList.size();i++){
            System.out.println((i+1)+") "+ exActualExam.questionList.get(i).questionPrompt);
        }
        System.out.println();
        int exToBeRemoved = Integer.parseInt(scanner.nextLine());
        UI.clearScreen();
        System.out.println("Weet u zeker dat u deze vraag wil verwijderen\n" + exActualExam.questionList.get(exToBeRemoved).questionPrompt);
        System.out.println("Y\\N?");
        exRemoveQuestLoop: while (true){
            switch(scanner.nextLine()){
                case("y"):
                case("Y"):
                case("yes"):
                case("Yes"):
                case("j"):
                case("J"):
                case("ja"):
                case("Ja"):
                    exActualExam.questionList.remove(exToBeRemoved);
                    System.out.println("Vraag verwijderd.\nReturning to menu...");
                    break exRemoveQuestLoop;
                case("n"):
                case("N"):
                case("no"):
                case("No"):
                case("nee"):
                case("Nee"):
                    System.out.println("Vraag verwijderen geannuleerd.\nReturning to menu...");
                    break exRemoveQuestLoop;
                default:
                System.out.println("Kies tussen: Yes(Y) of No(N)");
                    break;

            }
        }
        
    }

    public static int exChooseExamIndex(IScanner scanner, boolean exit) {
        Exam.printAllExams(scanner);
        if(exit){System.out.println("0) Keer terug naar het hoofdmenu");}
        Integer examNr;
        while (true){
            String exChooseExChoice = scanner.nextLine();
            try{
                examNr = Integer.parseInt(exChooseExChoice);
                break;
            }
            catch(Exception e){System.out.println("Kies een optie uit de lijst");}
        }
        return examNr-1;
    }

    public static ArrayList<String> exGetQuestCont(IScanner scanner) {
        ArrayList<String> exQuestContents = new ArrayList<>();
        System.out.println("Voer de vraag in:");
        exQuestContents.add(scanner.nextLine());
        exGetQuestLoop: while (true){
            System.out.println("Voer een vraag in met aan het begin: A),B),C) etc. Voer 0 in om door te gaan");
            String exUserChoice = scanner.nextLine();
            switch(exUserChoice){
                case("0"):
                    break exGetQuestLoop;
                default:
                    exQuestContents.add(" "+exUserChoice);
                    break;
            }
        }
        UI.clearScreen();
        System.out.println("Welke vraag is het juiste antwoord?(Zo lang we letters gebruiken ipv nummers moet dit een letter zijn)");
        exPrintQuestArray(exQuestContents,false);
        exQuestContents.add(scanner.nextLine());
        return exQuestContents;
    }

    public static void exPrintQuestArray(ArrayList<String> contents,boolean numbered) {
        System.out.println("Vraag 1:");
        for(int i=0;i<contents.size();i++){
            if(numbered){
                System.out.println((i+1)+" "+contents.get(i));
            }
            else{
            System.out.println(contents.get(i));
            }
        }
        
    }
}
