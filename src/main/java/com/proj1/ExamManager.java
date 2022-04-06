package com.proj1; import java.util.ArrayList; import java.util.Scanner;


/*
=======Class Explanation=======
This class manages creating, deleting & editing exams and the questions in them.
Thanks for coming to my TED talk.
*/

abstract public class ExamManager {

    public static void exManagerMenu(Scanner scanner) {
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
                    App.clearScreen();
                    System.out.println("Returning to main menu...");
                    Debug.wait(1);
                    break exManagerLoop;
                default:
                    System.out.println("Please choose a listed option...");
                    Debug.wait(2);
                    break;
            }
        }
    }

    public static void printExManagerMenu() {
        App.clearScreen();
        System.out.println("Welcome to the KekCorp© Exam Manager.");
        System.out.println("Please choose an option:\n");
        System.out.println("1) Add a new Exam");
        System.out.println("2) Remove a Exam");
        System.out.println("3) Edit Exam Questions");
        System.out.println("0) Exit");
    }

    //Action methods
    public static void exNewExam(Scanner scanner) {
        System.out.println("Enter the Exam name:");
        String newExName = scanner.nextLine();
        System.out.println("Enter the Exam category:");
        String newExCat = scanner.nextLine();
        Exam exManagerCreated = new Exam(newExName, newExCat);
        System.out.println("Exam created, do you wish to add Questions now?\n1)Yes\n2)No");
        if(scanner.nextLine().equals("1")){
            exAddQuestion(exManagerCreated,scanner);
        }
        System.out.println("Exam Created!\nReturning to main menu now");
        Debug.wait(2);
    }

    public static void exAddQuestion(Exam exam,Scanner scanner) {
        exAddQuestLoop1: while(true){
            App.clearScreen();
            System.out.println("The selected exam has currently "+exam.getQuestionList().size()+" Questions\n");
            System.out.println("Please choose an option:\n1) Make a new question\n2) View current questions\n0) Return to main menu");
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
    public static void exRemoveExam(Scanner scanner,int exToBeRemoved) {
        App.clearScreen();
        System.out.println("Are you Sure you want to remove\n" + Exam.examList.get(exToBeRemoved).getName() + " - " +Exam.examList.get(exToBeRemoved).getCategory()+"?");
        System.out.println("Y\\N");
        exRemoveLoop: while (true){
            switch(scanner.nextLine()){
                case("Y"):
                case("y"):
                case("yes"):
                    Exam.examList.remove(exToBeRemoved);
                    System.out.println("Exam removed.\nReturning to Exam menu");
                    break exRemoveLoop;
                case("N"):
                case("n"):
                case("No"):
                    System.out.println("Remove aborted.\n Returning to Exam menu");
                    break exRemoveLoop;
                default:
                System.out.println("Please choose either Yes(Y) or No(N)");
                    break;

            }
        }
        
    }

    public static void exEditExam(Scanner scanner) {
        exEditMainLoop: while(true){
            System.out.println("Choose an Exam to edit");
            int exIndex = exChooseExamIndex(scanner,true);
            if(exIndex != -1){
                Exam exActualExam = Exam.examList.get(exIndex);
                while (true){
                    System.out.println("What question to edit?");
                    for(int i = 0; i< exActualExam.questionList.size();i++){
                        System.out.println((i+1)+") "+ exActualExam.questionList.get(i).questionContents.get(0));
                    }
                    System.out.println("0) Exit");
                    int exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
                    if(exUserEditChoice != -1){
                        Question exChosenQuest = exActualExam.questionList.get(exUserEditChoice);
                        App.clearScreen();
                        exPrintQuestArray(exChosenQuest.questionContents, true);
                        System.out.println("What line to edit?");
                        exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
                        App.clearScreen();
                        System.out.println("Old Line:");
                        System.out.println(exChosenQuest.questionContents.get(exUserEditChoice));
                        System.out.println("New line:");
                        exChosenQuest.questionContents.set(exUserEditChoice, scanner.nextLine());
                        System.out.println("Line changed");
                        App.pauseMenu(scanner);
                    }
                    else{break;}
                }
            }
            else{break exEditMainLoop;}

        }
        
    }

    

    //Support methods
    public static int exChooseExamIndex(Scanner scanner, boolean exit) {
        Exam.printAllExams(scanner);
        if(exit){System.out.println("0) Exit");}
        Integer examNr;
        while (true){
            String exChooseExChoice = scanner.nextLine();
            try{
                examNr = Integer.parseInt(exChooseExChoice);
                break;
            }
            catch(Exception e){System.out.println("Please choose a valid option");}
        }
        return examNr-1;
    }

    public static ArrayList<String> exGetQuestCont(Scanner scanner) {
        ArrayList<String> exQuestContents = new ArrayList<>();
        System.out.println("Enter question prompt:");
        exQuestContents.add(scanner.nextLine());
        exGetQuestLoop: while (true){
            System.out.println("Enter question options prefix with A),B),C) etc. press 0 to confirm");
            String exUserChoice = scanner.nextLine();
            switch(exUserChoice){
                case("0"):
                    break exGetQuestLoop;
                default:
                    exQuestContents.add(" "+exUserChoice);
                    break;
            }
        }
        App.clearScreen();
        System.out.println("Which option is the right one?(Zo lang we letters gebruiken ipv nummers moet dit een letter zijn)");
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
