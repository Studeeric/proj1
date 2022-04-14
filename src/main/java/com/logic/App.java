package com.logic; 
import com.ui.AppUI;
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
                        getStudents(james);
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

    // getStudents //TODO Sysout naar UI
    private static void getStudents(IScanner scanner) {
        for (Student s : Student.studentList) {
            System.out.println(s.getName());
        }
        pauseMenu(scanner);
    }
    
    //studentExamStatus 
    // TODO kijken hoe deze gemerged kan worden met develop.
    // TODO kijken of deze method opgesplitst kan worden.
    // Is dit niet erg dubbelop met studentExamPassed?
    public static void studentExamStatus(IScanner scanner){
        while (true) {
            int studentNumber = askStudentNumber(scanner);
            boolean studentFound = false;
            for (int i = 0; i < Student.studentList.size(); i++) {
                if (Student.studentList.get(i).getStudentNumber() == studentNumber) {
                    studentNumber = i;
                    studentFound = true;
                    break;
                }
            }
            if(studentFound){
                UI.clearScreen();
                AppUI.printExamenColourCodes();
                Exam.printAllExamsColourCoded(scanner, Student.studentList.get(studentNumber));
                break;
            }
            break;
        }
        pauseMenu(scanner);
        UI.clearScreen();
    }

    //studentExamPassed
    // TODO kijken hoe deze gemerged kan worden met develop.
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
                while (examNummer > Exam.examList.size()){
                    AppUI.printChooseValidOption(1);
                    examNummer = scanner.nextInt();
                }
                if (examNummer == 0) {
                    break ExamensLoop;
                }
                if (examNummer <= Exam.examList.size() || examNummer >= Exam.examList.size()) {
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
            if(!studentGegevensAfwezig(scanner)){
                return -1;
            }
            
        }
    }

    //studentGegevensAfwezig
    public static boolean studentGegevensAfwezig(IScanner scanner) {
        AppUI.studentGegevensAfwezigMessage(1);
        while (true) {
            int studentNotFoundKeuze = scanner.nextInt();
            if (studentNotFoundKeuze >= 0 && studentNotFoundKeuze < 3) {
                switch (studentNotFoundKeuze) {
                    case 1:
                        UI.clearScreen();
                        return true;
                    case 2:
                        UI.clearScreen();
                        Student.newStudent(scanner);
                        return true;
                    case 0:
                        return false;
                    default:
                        UI.clearScreen();
                        AppUI.printChooseValidOption(6);
                        return false;
                }
            } else {
                AppUI.printChooseValidOption(1);
                pauseMenu(scanner);
                UI.clearScreen();
                AppUI.studentGegevensAfwezigMessage(2);
            }
        }
    }
}
