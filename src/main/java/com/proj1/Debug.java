package com.proj1;

public class Debug {

    public static void printQuestions(){
        for(Exam exam : Exam.examList){
            for(Question question : exam.questionList){
                System.out.println(question.contentsInString());
            }
        }

    }
    
}
