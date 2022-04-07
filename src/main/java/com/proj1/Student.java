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

    public static void newStudent(Scanner obiScanKenobi){
        try{
            newStudentloop1: while(true){
                String naam;
                newStudentloop2:while(true){
                    System.out.println ("Voer je naam in:");
                    naam = obiScanKenobi.nextLine();
                    if (naam.equals("")){
                        System.out.println("Geen naam ingevoerd, probeer het opnieuw.");
                    }
                    else{
                        break newStudentloop2;
                    }
                }
                naam = naam.replace("\n", "");
                int nummer = studentNumberStrToInt(obiScanKenobi);
                checkStudentNumber(nummer, naam, obiScanKenobi);  
                Student student = new Student (naam, nummer);
                System.out.println(student.getName() + " is toegevoegd aan de student lijst.");
                App.pauseMenu(obiScanKenobi); 
                break newStudentloop1; 
            }        
        }
        catch(Exception e){
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }
    
    public static void checkStudentNumber (int nummer, String naam, Scanner kristoff){
        int nummer2;
        try{
        for (Student e : Student.studentList){
            if (e.getStudentNumber() == nummer){
                    System.out.println("Studentnummer bestaat al. Kies een ander nummer.");
                    App.pauseMenu(kristoff);
                    App.clearScreen();
                    nummer2 = studentNumberStrToInt(kristoff);
                    checkStudentNumber(nummer2, naam, kristoff);
                }
            }
            if (nummer <= 0 ){
                System.out.println("Studentnummer is niet geldig. Kies een ander nummer");
                App.pauseMenu(kristoff);
                App.clearScreen();
                nummer2 = studentNumberStrToInt(kristoff);
                checkStudentNumber(nummer2, naam, kristoff);
            }
        }
        catch(Exception e){
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }

    public static int studentNumberStrToInt(Scanner jimmy){
        while(true){
            try{
                System.out.println("Voer je studentnummer in:");
                return Integer.parseInt(jimmy.nextLine());
            } catch (NumberFormatException s){
                System.out.println("Voer alleen cijfers in.");
                App.pauseMenu(jimmy);
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
