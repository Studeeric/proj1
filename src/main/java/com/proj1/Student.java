package com.proj1;

import java.util.ArrayList;

public class Student {
    private String name;
    private int studentNumber;
    private static ArrayList<Student> studentList;
    public Arraylist<Student> behaaldeExamens;
    private Exam examen;

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

    public void getPassed(){
        
        
    }
}
