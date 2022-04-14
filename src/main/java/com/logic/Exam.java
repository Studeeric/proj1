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
            ExamUI.printQuestion(i, currentQuestions);
            for(int j=0;j<currentQuestions.get(i).askQuestion().size();j++){
                ExamUI.printQuestionChoices(i, j, currentQuestions);
            }
            if(currentQuestions.get(i).checkAnswer(scanner.nextLine())){
                correct++;
            }
            UI.clearScreen();
            ExamUI.printAmountCorrect(correct);
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
            ExamUI.printSuccesfulExam(correct, questionList.size());
        } else{
            ExamUI.printFailedExam(correct, questionList.size());
        }
    }

    public static void printAllExams(IScanner scanner){
        if (examList.isEmpty()){
            ExamUI.printNoExams();
            App.pauseMenu(scanner);
        } else {
            for (int i = 0; i < examList.size(); i++) {
                ExamUI.printExam(i, examList);
            }
        }
    }
    public static void printAllExamsColourCoded(IScanner scanner, Student student) {
        if (examList.isEmpty()){
            ExamUI.printNoExams();
            App.pauseMenu(scanner);
        } else {
            boolean passed;
            for (Exam exam : Exam.examList) {
                passed = false;
                for(Exam studentExam : student.behaaldeExamens){
                    if(exam.name.equals(studentExam.name) && exam.questionList.equals(studentExam.questionList)){
                        String examFormat = exam.getName() + " - " + exam.getCategory();
                        ExamUI.printExamColourCoded(examFormat, true);
                        passed = true;
                        break;
                    }
                }
                if(!passed){
                    String examFormat = exam.getName() + " - " + exam.getCategory();
                    ExamUI.printExamColourCoded(examFormat, false);
                }
            }
        }
        
    }
}
