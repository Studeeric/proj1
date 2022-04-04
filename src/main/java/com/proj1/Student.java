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

    //fixen dat er geen twee newstudents zijn
    public static void newStudent(Scanner scanner){
        try{
            
            System.out.println ("Voer je naam:");
            String naam = scanner.nextLine();
            naam = naam.replace("\n", "");
            System.out.println("Voer je studentnummer in:");
            int nummer = scanner.nextInt();
            checkStudentNumber(nummer, naam, scanner);

            /*
            scanner.nextLine();
            Student student = new Student (naam, nummer);
            System.out.println(student.getName() + " is toegevoegd aan de student lijst.");
            System.out.println("Press return to continue");
            scanner.nextLine();
            */
        }
        catch(Exception e){
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }
    
    //Lucas fix this,
    public static void newStudent2(Scanner scanner, String naam){
        try{
            System.out.println("Voer je studentnummer in:");
            int nummer = scanner.nextInt();
            checkStudentNumber(nummer, naam, scanner);
            scanner.nextLine();
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
        for (Student e : Student.studentList){
            if (e.getStudentNumber() == nummer){
            System.out.println("Studentnummer bestaat al kies een ander numnmer.");
            newStudent2(scanner, naam);
            }
        }
    }
    
    public static void deleteStudent(Scanner scanner){
        try{
            int counter = 1;
            for (Student e : Student.studentList){
                System.out.println(counter+") "+e.getName());
                counter++;
            }
            System.out.println("0) Terug naar het hoofdmenu");
            System.out.println("Kies een student");
            int userRemoveStudentChoice = scanner.nextInt();
            scanner.nextLine();
            if (userRemoveStudentChoice == 0){
                System.out.println("Returning to main menu...");
            }else{
                Student.studentList.remove(userRemoveStudentChoice-1);
                System.out.println("Student removed");
                System.out.println("Press return to continue");
                scanner.nextLine();
            }
        }
        catch(Exception e){
            System.out.println("Error in deleteStudent");
            System.out.println(e);
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
