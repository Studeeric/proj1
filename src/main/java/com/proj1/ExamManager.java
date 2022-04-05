package com.proj1; import java.util.Scanner;

/*
=======Class Explanation=======
This class manages creating,deleting & editing exams and the questions in them.
Thanks for coming to my TED talk.
*/

abstract public class ExamManager {

    public static void exManagerMenu(Scanner scanner) {
        exManagerLoop: while (true) {
            
        
            printExManagerMenu();
            String userChoiceExManager = scanner.nextLine();
            switch(userChoiceExManager){
                case("1"):
                    App.clearScreen();
                    exNewExam(scanner);
                    break;
                    
                case("0"):
                    App.clearScreen();
                    System.out.println("Returning to main menu...");
                    Debug.wait(1);
                    break exManagerLoop;
                default:
                    System.out.println("Please choose a listed option...");
                    Debug.wait(3);
                    break;
            }
        }
    }
    public static void printExManagerMenu() {
        App.clearScreen();
        System.out.println("Welcome to the KekCorp© Exam Manager");
        System.out.println("Please choose a option");
        System.out.println("Add a new Exam");
        System.out.println("Remove a Exam");
        System.out.println("Edit Exam Questions");
        System.out.println("Exit");
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
            exAddQuestion(exManagerCreated);
        }
        System.out.println("Exam Created!\nReturning to main menu now");
        Debug.wait(1);
    }

    public static void exAddQuestion(Exam exam) {
        
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
