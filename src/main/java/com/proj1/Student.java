package com.proj1;

import java.util.Scanner; 
import java.util.ArrayList;

public class Student {
    private String name;
    private int studentNumber;
    public static ArrayList<Student> studentList;
    public ArrayList<Exam> behaaldeExamens;
    //private Exam examen;

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
        System.out.println ("Voer je naam en studentnummer in:");
        String naam = scanner.nextLine();
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
        int studentNR = 0;
        for (int i = 0; i < studentList.size(); i++){
            if (totaal < studentList.get(i).behaaldeExamens.size()){
                totaal = studentList.get(i).behaaldeExamens.size();
                studentNR = i;
            }

        }
        System.out.println(studentList.get(studentNR).getName() + " heeft maar liefst " + totaal + " examens gehaald.");
    }
}
