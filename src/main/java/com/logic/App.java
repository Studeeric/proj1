package com.logic; 
import com.ui.AppUI;
import com.ui.UI;

public class App {
    public static void main( String[] args){
        ScannerV3 scannakin = new ScannerV3();
        Init.init(false,scannakin);
        mainMenu(scannakin);
        SaveManager.exitSave();
    }

    //mainMenu
    public static void mainMenu(IScanner james) {
        mainMenuLoop: while (true) {
            AppUI.printMainMenu();
            int chooseAction = 10;//Any non valid option will work
            chooseAction = james.nextInt();
            try {
                switch (chooseAction) {
                    case (1):
                        UI.clearScreen();
                        Exam.printAllExams(james);
                        pauseMenu(james);
                        break;
                    case (2):
                        UI.clearScreen();
                        getStudents(james);
                        break;
                    case (3):
                        UI.clearScreen();
                        Student.newStudent(james);
                        break;
                    case (4):
                        UI.clearScreen();
                        Student.deleteStudent(james);
                        break;
                    case (5):
                        UI.clearScreen();
                        startExams(james);
                        break;
                    case (6):
                        UI.clearScreen();
                        studentExamStatus(james);
                        break;
                    case (7):
                        UI.clearScreen();
                        studentExamPassed(james);
                        break;
                    case (8):
                        UI.clearScreen();
                        Student.studentMostPassed(james);
                        break;
                    case(9):
                        ExamManager.exManagerMenu(james);
                        break;
                    case(0):
                        AppUI.printSaveMessage();
                        break mainMenuLoop;
                    default:
                        AppUI.printChooseValidOption(1);
                        break;
                }
            } catch (Exception e) {
                AppUI.errorMessageApp(e, "mainMenu");
                pauseMenu(james);
            }
        }
    }

    // getStudents
    private static void getStudents(IScanner scanner) {
        for (Student s : Student.studentList) {
            System.out.println(s.getName());
        }
        pauseMenu(scanner);
    }
    
    //studentExamStatus
    public static void studentExamStatus(IScanner scanner){
        int studentNumber = askStudentNumber(scanner);
        // For loop veranderd de variabele studentnumber naar index van studentList.
        for (int i = 0; i < Student.studentList.size(); i++) {
            if (Student.studentList.get(i).getStudentNumber() == studentNumber) {
                studentNumber = i;
                break;
            }
        }
        UI.clearScreen();
        int examNummer;
        studentExamStatus: while (true) {
            examChoice: while (true) {
                System.out.println("Examens beschikbaar:");
                Exam.printAllExams(scanner);
                AppUI.printOptionGoBackToMainMenu();
                AppUI.voerXIn("examnr");
                try {
                    examNummer = Integer.parseInt(scanner.nextLine());
                    break examChoice;
                } catch (NumberFormatException e) {
                    AppUI.printChooseValidOption(2);
                    pauseMenu(scanner);
                }
            }
            examNummer--;
            boolean gehaald = false;
            if (examNummer <= Exam.examList.size() && examNummer >= 0) {
                for (int i = 0; i < Student.studentList.get(studentNumber).behaaldeExamens.size(); i++) {
                    if (Student.studentList.get(studentNumber).behaaldeExamens.get(i)
                            .equals(Exam.examList.get(examNummer))) {
                        gehaald = true;
                    }
                }
            }
            if (examNummer == -1) {
                System.out.println("U keer terug naar het hoofdmenu.");
                break studentExamStatus;
            }
            
            if (examNummer >= Exam.examList.size() || examNummer < -1) {
                AppUI.printChooseValidOption(3);
                pauseMenu(scanner);
            } else {
                AppUI.studentHeeftExamenWelNietGehaald(gehaald, Exam.getExam(examNummer).getName());
            }

            UI.clearScreen(); //in both cases UI.clearScreen() gets called.
            
        }
        pauseMenu(scanner);
    }

    //studentExamPassed
    public static void studentExamPassed(IScanner scanner){
        int studentNumber = askStudentNumber(scanner);
        boolean studentFound = false;
        for (int i = 0; i < Student.studentList.size(); i++) {
            if (Student.studentList.get(i).getStudentNumber() == studentNumber) {
                studentNumber = i;
                studentFound = true;
                break;
            }
        }
        if (studentFound) {
            int counter = 1;
            if (Student.studentList.get(studentNumber).behaaldeExamens.size() > 0) {
                for (Exam exam : Student.studentList.get(studentNumber).behaaldeExamens) {
                    System.out.println(counter + ") " + exam.getName() + " - " + exam.getCategory());
                    counter++;
                }
            } else {
                AppUI.printNoExamsPassed();
            }
        } else {
            AppUI.printChooseValidOption(4);
        }
        pauseMenu(scanner);
    }

    //StartExams
    public static void startExams(IScanner scanner){
        int studentNumber = askStudentNumber(scanner);
        for (int i = 0; i < Student.studentList.size(); i++) {
            if(studentNumber == Student.studentList.get(i).getStudentNumber()){
                studentGegevensAanwezig(Student.studentList.get(i), scanner);
            }            
        }
        pauseMenu(scanner);
    }

    private static void studentGegevensAanwezig(Student student,IScanner scanner){
        try{
            int examNummer;
            ExamensLoop: while (true) {
                UI.clearScreen();
                System.out.println("Examens beschikbaar:");
                Exam.printAllExams(scanner);
                System.out.println("0) Terug naar het hoofdmenu");
                System.out.println("Voer het nummer van het examen in:");
                try {
                    examNummer = Integer.parseInt(scanner.nextLine());
                    if (examNummer == 0){
                        break ExamensLoop;
                    }
                    if (examNummer <= Exam.examList.size() && examNummer >= Exam.examList.size()){
                        Exam.examList.get(examNummer-1).startExam(student, scanner);
                    } else {
                        AppUI.printChooseValidOption(5);
                        pauseMenu(scanner);
                    }
                
                } catch (NumberFormatException e) {
                    AppUI.printChooseValidOption(2);
                    pauseMenu(scanner);
                }
            }
        } catch (Exception e){
            System.out.println("Error in studentGegevensAanwezig");
            System.out.println(e);
        }
    }


    public static void pauseMenu(IScanner scanner) {
        System.out.println("Press return to continue.");
        try {
            scanner.nextLine(); // This is just here to wait for input
        } catch (Exception e) {
            AppUI.errorMessageApp(e, "pauseMenu");
        }
    }

    private static int askStudentNumber(IScanner scanner) {
        while (true) {
            AppUI.voerXIn("studentnr");
            int input = scanner.nextInt();
            for (int i = 0; i < Student.studentList.size(); i++) {
                if (input == Student.studentList.get(i).getStudentNumber()) {
                    return input;
                }
            }
            studentGegevensAfwezig(scanner);
        }
    }

    public static void studentGegevensAfwezig(IScanner scanner){
        AppUI.studentGegevensAfwezigMessage();
        int studentNotFoundKeuze = scanner.nextInt();
            switch(studentNotFoundKeuze){
                case 1:
                    break;//NO. No recursion
                case 2:
                    Student.newStudent(scanner);
                    break;//Break the for loop & run this method again
                case 0: 
                    break;//Break the while loop & go back to mainMenu
                default:
                    AppUI.printChooseValidOption(6);
                    break;
            }      
    }
}
