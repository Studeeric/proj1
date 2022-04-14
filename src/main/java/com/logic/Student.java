package com.logic; import java.util.ArrayList;

import com.ui.StudentUI;
import com.ui.UI;

public class Student {
    private String name;
    private int studentNumber;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public ArrayList<Exam> behaaldeExamens = new ArrayList<>();

    public Student(String name, int studentNumber){
        this.name = name;
        this.studentNumber = Math.abs(studentNumber);
        studentList.add(this);
    }

    public String getName(){
        return this.name;
    }

    public int getStudentNumber(){
        return this.studentNumber;
    }

    public static void newStudent(IScanner scanner) {
        try {
            String naam = "";
            // Loops name input
            while (naam.equals("")) {
                StudentUI.printAskName(true);
                naam = scanner.nextLine();
                naam = naam.replace("\n", "");
                if (naam.equals("")) {
                    StudentUI.printAskName(false);
                }
            }
            int nummer = checkStudentNumber(scanner);
            if (nummer != 0) {
                Student student = new Student(naam, nummer);
                StudentUI.printStudentMadeSuc(student.getName());
                App.pauseMenu(scanner);
            }
        } catch (Exception e) {
            StudentUI.printException(e);
        }
    }
    
    /** Returns the studentnumber that the user inputted.
     @param scanner
     @return int
    */
    public static int checkStudentNumber(IScanner scanner) {
        while (true) {
            boolean unique = true;
            int nummer = studentNumberStrToInt(scanner);
            for (Student student : studentList) {
                if (student.getStudentNumber() == nummer) {
                    unique = false;
                    StudentUI.printNumExist();
                    StudentUI.printTryAgain();
                    if (scanner.nextLine().equals("0")) {
                        StudentUI.printReturnMainMenu();
                        App.pauseMenu(scanner);
                        return 0;
                    }
                    UI.clearScreen();
                }
            }
            if (unique) {
                if (nummer < 0 || nummer > 99999999) {
                    StudentUI.printTryAgain();
                    if (scanner.nextLine().equals("0")) {
                        // StudentUI.printNumInv();
                        StudentUI.printReturnMainMenu();
                        App.pauseMenu(scanner);
                        return 0;
                    }
                    UI.clearScreen();
                } else {
                    return nummer;
                }
            }
        }
    }

    /**Asks studentnumber and tries to turn the string into an int.
     * @param scanner
     * @return int
    */
    public static int studentNumberStrToInt(IScanner scanner){
        while(true){
            try{
                StudentUI.printAskNumber(true);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException s){
                StudentUI.printAskNumber(false);
                App.pauseMenu(scanner);
                UI.clearScreen();
            }    
        }
    }

    public static void deleteStudent(IScanner scanner) {
        while (true) {
            UI.clearScreen();
            StudentUI.printAllStudents(true);
            StudentUI.printChooseStudent();
            int userRemoveStudentChoice;
            userRemoveStudentChoice = scanner.nextInt();
            if (userRemoveStudentChoice >= 0 && userRemoveStudentChoice <= Student.studentList.size()) {
                if (userRemoveStudentChoice == 0) {
                    break;
                } else {
                    Student.studentList.set((userRemoveStudentChoice - 1), null);
                    Student.studentList.remove(userRemoveStudentChoice - 1);
                    StudentUI.printStudentRemove(true);
                    App.pauseMenu(scanner);
                }
            } else {
                StudentUI.printStudentRemove(false);
                App.pauseMenu(scanner);
            }
        }
    }

    public static void studentMostPassed(IScanner scanner){

        int meesteNrBehaaldeExamens = 0;
        ArrayList<String> namenStudentenMetMostPassed = new ArrayList<>();

        for (int i = 0; i < studentList.size(); i++){
            if (meesteNrBehaaldeExamens < studentList.get(i).behaaldeExamens.size()){
                meesteNrBehaaldeExamens = studentList.get(i).behaaldeExamens.size();
            }
        }

        for (int i = 0; i < studentList.size(); i++){
            if (meesteNrBehaaldeExamens == studentList.get(i).behaaldeExamens.size()){
                namenStudentenMetMostPassed.add(studentList.get(i).getName());
            }
        }

        if (namenStudentenMetMostPassed.size()==1){
            StudentUI.printMostPassed(1, meesteNrBehaaldeExamens, namenStudentenMetMostPassed, 0);
        } else {
            StudentUI.printMostPassed(2, meesteNrBehaaldeExamens, namenStudentenMetMostPassed, 0);
            for (int n = 0; n < namenStudentenMetMostPassed.size(); n++){
                StudentUI.printMostPassed(3, meesteNrBehaaldeExamens, namenStudentenMetMostPassed, 0);
                if (n < (namenStudentenMetMostPassed.size()-1)){
                    StudentUI.printMostPassed(4, meesteNrBehaaldeExamens, namenStudentenMetMostPassed, n);
                }
            }
            StudentUI.printMostPassed(5, meesteNrBehaaldeExamens, namenStudentenMetMostPassed, 0);
        } 
        App.pauseMenu(scanner);
    }
}
