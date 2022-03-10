package com.proj1;

import java.util.ArrayList;

public class Student {
    private String name;
    private int studentNumber;
    public static ArrayList<Student> studentList;
    private Exam examen;

    public Student(String name, int studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;

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
