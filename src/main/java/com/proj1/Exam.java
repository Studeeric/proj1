package com.proj1;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam {
    private String name;
    private String category;
    public static ArrayList<Exam> examList;
    private ArrayList<Question> questionList;
    private Scanner scanner = new Scanner(System.in);


    /*  ATTENTION
        Exam kan pas goed getest worden zodra Exam en Question en Student gemerged zijn.
        Questions moeten nog toegevoegd worden bij initialization.
    */

    public Exam(String name, String category){
        this.name = name;
        this.category = category;
        questionList.add(null);
        examList.add(this);
    }

    public void startExam(Student student){
        int correct = 0;
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println("Vraag " + i + ":");
            System.out.println(questionList.get(i).askQuestion());
            if(questionList.get(i).checkAnswer(scanner.nextLine())){
                correct++;
            }
        }
        checkPassed(correct, student);
    }

    public void checkPassed(int correct, Student student){
        if(correct >= (questionList.size()/2)){
            student.behaaldeExamens.add(this);
            System.out.println("Gefeliciteerd! Je hebt het examen gehaald.\n" +
                                "Je hebt " + correct + " van de " + questionList.size() + "vragen goed.");
        } else {
            System.out.println("Helaas... Je hebt het examen niet gehaald.\n" +
                                "Je hebt " + correct + " van de " + questionList.size() + "vragen goed.\n" +
                                "Volgende keer beter!");
        }

    }

}
