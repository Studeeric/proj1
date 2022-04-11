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
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }
    
    /** Returns the studentnumber that the user inputted.
     * 
     * @param scanner
     * @return int
    */
    public static int checkStudentNumber(IScanner scanner) {
        while (true) {
            boolean unique = true;
            int nummer = studentNumberStrToInt(scanner);
            for (Student student : studentList) {
                if (student.getStudentNumber() == nummer) {
                    unique = false;
                    System.out.println("Studentnummer bestaat al. Kies een ander nummer.");
                    System.out.println("Indien u wenst te annuleren, voer 0 in.");
                    System.out.println("Toets iets anders in om het opnieuw te proberen.");
                    if (scanner.nextLine().equals("0")) {
                        System.out.println("U keert nu terug naar het hoofdmenu.");
                        App.pauseMenu(scanner);
                        return 0;
                    }
                    UI.clearScreen();
                }
            }
            if (unique) {
                if (nummer < 0 || nummer > 99999999) {
                    System.out.println("Nummer ongeldig. Kies een ander nummer.");
                    System.out.println("Indien u wenst te annuleren, voer 0 in.");
                    System.out.println("Toets iets anders in om het opnieuw te proberen.");
                    if (scanner.nextLine().equals("-1")) {
                        System.out.println("U keert nu terug naar het hoofdmenu.");
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
     * 
     * @param scanner
     * @return int
    */
    public static int studentNumberStrToInt(IScanner scanner){
        while(true){
            try{
                System.out.println("Voer je studentnummer (max 8 cijfers) in:");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException s){
                System.out.println("Voer alleen cijfers in.");
                App.pauseMenu(scanner);
                UI.clearScreen();
            }    
        }
    }

   
    
    public static void deleteStudent(IScanner scanner){
        while (true){
            UI.clearScreen();
            StudentUI.printAllStudents(true);
            System.out.println("Kies een student:");
            int userRemoveStudentChoice;
            try {
                userRemoveStudentChoice = Integer.parseInt(scanner.nextLine());
                if (userRemoveStudentChoice == 0){
                    break;
                } else {
                    Student.studentList.set((userRemoveStudentChoice-1),null);
                    Student.studentList.remove(userRemoveStudentChoice-1);
                    StudentUI.printStudentRemove(true);
                    App.pauseMenu(scanner);
                }
            } catch (NumberFormatException e){
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
            System.out.println(namenStudentenMetMostPassed.get(0) + " heeft maar liefst " + meesteNrBehaaldeExamens + " examens gehaald.");   
        } else {
            System.out.println("Er zijn "+ namenStudentenMetMostPassed.size() + " Studenten die allemaal de meeste examens gehaald hebben.");
            System.out.println("");
            for (int n = 0; n < namenStudentenMetMostPassed.size(); n++){
                System.out.print(namenStudentenMetMostPassed.get(n));
                if (n < (namenStudentenMetMostPassed.size()-1)){
                    System.out.print(", ");
                }
            }
            System.out.print(" hebben allemaal " + meesteNrBehaaldeExamens + " examens behaald.");
            System.out.println("");
        }
        
        App.pauseMenu(scanner);
    }
}
