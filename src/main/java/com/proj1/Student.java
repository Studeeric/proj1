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

    public static void newStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Voer je naam:");
        String naam = scanner.nextLine();
        naam = naam.replace("\n", "");
        System.out.println("Voer je studentnummer in:");
        int nummer = scanner.nextInt();
        Student newStudent = new Student (naam, nummer);
        System.out.println(newStudent.getName() + " is toegevoegd aan de student lijst.");
        scanner.close();
    }
    
    public static void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Voer je naam en studentnummer in:");
        String naam = scanner.nextLine();
        int nummer = scanner.nextInt();
        for (Student e : Student.studentList){
            if (e.name == naam && e.studentNumber == nummer){
                Student.studentList.remove(e);
                System.out.println ("Student succesvol verwijderd.");
            }else{
                System.out.println("Student niet gevonden.");
            }
        }
        scanner.close();
    }

    public static void studentMostPassed (){
        int totaal = 0;
        ArrayList<Integer> studentNR = new ArrayList<Integer>;
        for (int i = 0; i < studentList.size(); i++){
            if (totaal <= studentList.get(i).behaaldeExamens.size()){
                totaal = studentList.get(i).behaaldeExamens.size();
                studentNR.add(i);
            }
            
        if (studentNR.size() == 1){
            System.out.println(studentList.get(studentNR).getName() + " heeft maar liefst " + totaal + " examens gehaald.");
        }

        if (studentNR.size() > 1){
            System.out.println("Er zijn " + studentNR.size() + " studenten die allemaal de meeste examens gehaald hebben.");
            System.out.println("");
            for (int n = 0; n < studentNR.size(); n++){
                System.out.print(studentNR.get(n));
                if (n != studentNR.size()-1){
                    System.out.print(", ");
                }    
            }
            System.out.print(" hebben elk "+ totaal + " examens gehaald.");
        }
        //Als er een gelijkstand is in meeste examens behaald, zou het programma het volgende moeten doen:
        //Er zijn 5 studenten die allebei de meeste examens gehaald hebben.
        //
        //Eric, Lucas, Wessel, Burton, Wouter hebben elk 0 examens gehaald.
    }
}
