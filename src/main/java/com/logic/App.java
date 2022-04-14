package com.logic; 
import com.ui.AppUI;
import com.ui.StudentUI;
import com.ui.UI;

public class App {
    
    private App(){} //private constructor means no objects can be made of this class

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
            try {
                switch (james.nextLine()) {
                    case ("1"):
                        UI.clearScreen();
                        Exam.printAllExams(james);
                        pauseMenu(james);
                        break;
                    case ("2"):
                        UI.clearScreen();
                        StudentUI.printAllStudents(false);
                        pauseMenu(james);
                        break;
                    case ("3"):
                        UI.clearScreen();
                        Student.newStudent(james);
                        break;
                    case ("4"):
                        UI.clearScreen();
                        Student.deleteStudent(james);
                        break;
                    case ("5"):
                        UI.clearScreen();
                        startExams(james);
                        break;
                    case ("6"):
                        UI.clearScreen();
                        studentExamStatus(james);
                        break;
                    case ("7"):
                        UI.clearScreen();
                        studentExamPassed(james);
                        break;
                    case ("8"):
                        UI.clearScreen();
                        Student.studentMostPassed(james);
                        break;
                    case("9"):
                        ExamManager.exManagerMenu(james);
                        break;
                    case("0"):
                        AppUI.printSaveMessage();
                        break mainMenuLoop;
                    default:
                        AppUI.printChooseValidOption(1);
                        pauseMenu(james);
                        break;
                }
            } catch (Exception e) {
                AppUI.errorMessageApp(e, "mainMenu");
                pauseMenu(james);
            }
        }
    }
 
    //studentExamStatus 
    // TODO kijken of deze method opgesplitst kan worden.
    // Is dit niet erg dubbelop met studentExamPassed?
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
        pauseMenu(scanner);
        UI.clearScreen();
    }

    //studentExamPassed
    // TODO kijken of deze method opgesplitst kan worden.
    
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
                AppUI.printExamPassed(true, studentNumber, Student.studentList.get(studentNumber).behaaldeExamens.size());
                for (Exam exam : Student.studentList.get(studentNumber).behaaldeExamens) {
                    AppUI.printExamStudentExamPassed(counter, exam.getName(), exam.getCategory());
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

    //studentGegevensAanwezig
    private static void studentGegevensAanwezig(Student student,IScanner scanner){
        try{
            int examNummer;
            ExamensLoop: while (true) {
                UI.clearScreen();
                AppUI.printExamenBeschikbaar();
                Exam.printAllExams(scanner);
                AppUI.printOptionGoBackToMainMenu();
                AppUI.voerXIn("examnr");
                examNummer = scanner.nextInt();
                if (examNummer == 0) {
                    break ExamensLoop;
                }
                if (examNummer <= Exam.examList.size() && examNummer >= Exam.examList.size()) {
                    Exam.examList.get(examNummer - 1).startExam(student, scanner);
                } else {
                    AppUI.printChooseValidOption(5);
                    pauseMenu(scanner);
                }
            }
        } catch (Exception e){
            AppUI.errorMessageApp(e, "studentGegevensAanwezig");
        }
    }

    //pauseMenu
    public static void pauseMenu(IScanner scanner) {
        AppUI.printPressReturnToContinue();
        try {
            scanner.nextLine(); // This is just here to wait for input
        } catch (Exception e) {
            AppUI.errorMessageApp(e, "pauseMenu");
        }
    }

    //askStudentNumber
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

    //studentGegevensAfwezig
    public static void studentGegevensAfwezig(IScanner scanner){
        AppUI.studentGegevensAfwezigMessage();
        int studentNotFoundKeuze = scanner.nextInt();
            switch(studentNotFoundKeuze){
                case 1:
                    UI.clearScreen();
                    break;
                case 2:
                    Student.newStudent(scanner);
                    break;
                case 0: 
                    break;
                default:
                    AppUI.printChooseValidOption(6);
                    break;
        }      
    }
}
