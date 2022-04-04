package com.proj1; import java.util.Scanner; import java.util.ArrayList;

public class Student {
    private String name;
    private int studentNumber;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public ArrayList<Exam> behaaldeExamens = new ArrayList<>();

    public Student(String name, int studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
        studentList.add(this);
    }

    public String getName(){
        return this.name;
    }

    public int getStudentNumber(){
        return this.studentNumber;
    }

    public static void newStudent(Scanner scanner){
        try{
            System.out.println ("Voer je naam:");
            String naam = scanner.nextLine();
            naam = naam.replace("\n", "");
            System.out.println("Voer je studentnummer in:");
            int nummer = scanner.nextInt();
            checkStudentNumber(nummer, naam, scanner);  
            Student student = new Student (naam, nummer);
            System.out.println(student.getName() + " is toegevoegd aan de student lijst.");
            System.out.println("Press return to continue");
            scanner.nextLine();          
        }
        catch(Exception e){
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }
    
    public static void checkStudentNumber (int nummer, String naam, Scanner scanner){
        try{
        for (Student e : Student.studentList){
            if (e.getStudentNumber() == nummer){
                System.out.println("Studentnummer bestaat al kies een ander numnmer.");
                System.out.println("Voer je studentnummer in:");
                int nummer2 = scanner.nextInt();
                checkStudentNumber(nummer2, naam, scanner);
                scanner.nextLine();
                }
            }
        }
        catch(Exception e){
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }

    public static void printAllStudents(Scanner scanner){
        if (studentList.isEmpty()){
            System.out.println("Er zijn geen studenten.");
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println((i+1) + ") " + studentList.get(i).getName());
            }
        }
    }
    
    public static void deleteStudent(Scanner scanner){
        while (true){
            App.clearScreen();
            printAllStudents(scanner);
            System.out.println("0) Terug naar het hoofdmenu");
            System.out.println("Kies een student:");
            int userRemoveStudentChoice;
            try {
                userRemoveStudentChoice = Integer.parseInt(scanner.nextLine());
                if (userRemoveStudentChoice == 0){
                    System.out.println("Returning to main menu...");
                    break;
                } else {
                    Student.studentList.set((userRemoveStudentChoice-1),null);
                    Student.studentList.remove(userRemoveStudentChoice-1);
                    System.out.println("Student removed");
                    System.out.println("Press return to continue");
                    scanner.nextLine();
                }
            } catch (NumberFormatException e){
                System.out.println("Maak een valide keuze.");
                App.pauseMenu(scanner);
            }
        }    
    }

    public static void studentMostPassed (){

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
            System.out.println("Er zijn "+ namenStudentenMetMostPassed.size() + " Studenten die allemaal het meeste examens gehaald hebben.");
            System.out.println("");
            for (int n = 0; n < namenStudentenMetMostPassed.size(); n++){
                System.out.print(namenStudentenMetMostPassed.get(n));
                if (n < (namenStudentenMetMostPassed.size()-1)){
                    System.out.print(", ");
                }
            }
            System.out.print("hebben allemaal " + meesteNrBehaaldeExamens + " examens behaald.");
            System.out.println("");
        }
    }
}
