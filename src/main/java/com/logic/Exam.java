package com.logic; import java.util.ArrayList;
import java.util.Collections;

import com.ui.ExamUI;
import com.ui.UI;

public class Exam{
    private String name;
    private String category;
    public static ArrayList<Exam> examList = new ArrayList<>();
    public ArrayList<Question> questionList = new ArrayList<>();

    public Exam(String name, String category){
        this.name = name;
        this.category = category;
        examList.add(this);
    }

    public String getName(){
        return this.name;
    }
  
    public String getCategory(){
        return this.category;
    }

    public static Exam getExam(int getal){
        return examList.get(getal);
    }

    public void addQuestion(Question question){
          this.questionList.add(question);
    }
  
    public ArrayList<Question> getQuestionList(){
        return this.questionList;
    }

    public void startExam(Student student, IScanner scanner){
        int correct = 0;
        ArrayList<Question> currentQuestions = new ArrayList<>(questionList);
        Collections.shuffle(currentQuestions);
        UI.clearScreen();
        for (int i = 0; i < currentQuestions.size(); i++) {
            System.out.println("Vraag " + (i+1) + ":");
            System.out.println(currentQuestions.get(i).questionPrompt);
            for(int j=0;j<currentQuestions.get(i).askQuestion().size();j++){
                System.out.println((j+1)+ ") "+currentQuestions.get(i).askQuestion().get(j));
            }
            if(currentQuestions.get(i).checkAnswer(scanner.nextLine())){
                correct++;
            }
            UI.clearScreen();
            ExamUI.amountCorrect(correct);
        }
        if (correct >= ((currentQuestions.size()-1)/2+1)){ //Examens met een oneven aantal vragen zijn gehaald wanneer het meerendeel goed beantwoord wordt
            examResult(student, correct, true);
        } else {
            examResult(student, correct, false);
        }
    }

    public void examResult(Student student, int correct, boolean gehaald) {
        if(gehaald){
            boolean alreadyPassed = false;
            for(Exam exam : student.behaaldeExamens){
                if (exam.name.equals(this.name)&& exam.questionList.equals(this.questionList)){
                    alreadyPassed = true;
                }
            }
            if(!alreadyPassed){
                student.behaaldeExamens.add(this);
            }
            ExamUI.succesfulExam(correct, questionList.size());
        } else{
            ExamUI.failedExam(correct, questionList.size());
        }
    }

    public static void printAllExams(IScanner scanner){
        if (examList.isEmpty()){
            System.out.println("Er zijn momenteel geen examens beschikbaar.");
            App.pauseMenu(scanner);
        } else {
            for (int i = 0; i < examList.size(); i++) {
                System.out.println((i+1) + ") " + examList.get(i).getName() + " - " + examList.get(i).getCategory());
            }
        }
    }
}