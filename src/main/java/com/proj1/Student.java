package com.proj1; import java.util.Scanner; import java.util.ArrayList;

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

    public static void newStudent(Scanner scanner) {
        try {
            String naam = "";
            // Loops name input
            while (naam.equals("")) {
                System.out.println("Voer je naam in:");
                naam = scanner.nextLine();
                naam = naam.replace("\n", "");
                if (naam.equals("")) {
                    System.out.println("Geen naam ingevoerd, probeer het opnieuw.");
                }
            }
            int nummer = checkStudentNumber(scanner);
            if (nummer != 0) {
                Student student = new Student(naam, nummer);
                System.out.println(student.getName() + " is toegevoegd aan de student lijst.");
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
    public static int checkStudentNumber(Scanner scanner) {
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
                    App.clearScreen();
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
                    App.clearScreen();
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
    public static int studentNumberStrToInt(Scanner scanner){
        while(true){
            try{
                System.out.println("Voer je studentnummer (max 8 cijfers) in:");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException s){
                System.out.println("Voer alleen cijfers in.");
                App.pauseMenu(scanner);
                App.clearScreen();
            }    
        }
    }

    public static void printAllStudents(Scanner pedro){
        if (studentList.isEmpty()){
            System.out.println("Er zijn geen studenten.");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((i+1) + ") " + studentList.get(i).getName());
            }
        }
    }
    
    public static void deleteStudent(Scanner kim){
        while (true){
            App.clearScreen();
            printAllStudents(kim);
            System.out.println("0) Terug naar het hoofdmenu");
            System.out.println("Kies een student:");
            int userRemoveStudentChoice;
            try {
                userRemoveStudentChoice = Integer.parseInt(kim.nextLine());
                if (userRemoveStudentChoice == 0){
                    System.out.println("Returning to main menu...");
                    break;
                } else {
                    Student.studentList.set((userRemoveStudentChoice-1),null);
                    Student.studentList.remove(userRemoveStudentChoice-1);
                    System.out.println("Student removed");
                    System.out.println("Press return to continue");
                    kim.nextLine();
                }
            } catch (NumberFormatException e){
                System.out.println("Maak een valide keuze.");
                App.pauseMenu(kim);
            }
        }    
    }

    public static void studentMostPassed (Scanner jacques){

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
        
        App.pauseMenu(jacques);
    }
}
