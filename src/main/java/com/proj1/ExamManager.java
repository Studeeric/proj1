package com.proj1; import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println("Welcome to the KekCorp© Exam Manager");
        System.out.println("Please choose a option\n");
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
        Debug.wait(1);
    }

    public static void exAddQuestion(Exam exam,Scanner scanner) {
        exAddQuestLoop1: while(true){
            App.clearScreen();
            System.out.println("The selected exam has currently "+exam.getQuestionList().size()+" Questions");
            System.out.println("Please choose an option:\n1) Make a new question\n0) Return to main menu");
            switch (scanner.nextLine()) {
                case ("1"):
                    exam.addQuestion(new Question(exGetQuestCont(scanner)));
                    break;
                case ("0"):
                    break exAddQuestLoop1;
                default:
                    break;
            }
        }
    }

    public static ArrayList<String> exGetQuestCont(Scanner scanner) {
        ArrayList<String> exQuestContents = new ArrayList<>();
        System.out.println("Enter question prompt:");
        exQuestContents.add(scanner.nextLine());
        System.out.println("Enter question options, press 0 to confirm");
        String exUserChoice = scanner.nextLine();
        switch(exUserChoice){
            case("0"):
                break;
            default:
                exQuestContents.add(exUserChoice);
        }
        System.out.println("Which option is the right one?");
        exQuestContents.add(scanner.nextLine());
        return exQuestContents;
    }

    //Support methods
    public static Exam exChooseExam(Scanner scanner) {
        Exam.printAllExams(scanner);
        Integer examNr;
        while (true){
            String exChooseExChoice = scanner.nextLine();
            try{
                 examNr = Integer.parseInt(exChooseExChoice);
                break;
            }
            catch(Exception e){System.out.println("Please choose a valid option");}
        }
        return Exam.examList.get(examNr-1);
    }
}
