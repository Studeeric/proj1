package com.proj1; import java.util.ArrayList; import java.util.Scanner;

public class Exam {
    private String name;
    private String category;
    public static ArrayList<Exam> examList = new ArrayList<>();
    ArrayList<Question> questionList = new ArrayList<>();

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

    public void startExam(Student student, Scanner scanner){
        int correct = 0;
        for (int i = 1; i <= questionList.size(); i++) {
            System.out.println("Vraag " + i + ":");
            for(int j=0;j<questionList.get(i-1).askQuestion().size()-1;j++){
                System.out.println(questionList.get(i-1).askQuestion().get(j));
            }
            if(questionList.get(i-1).checkAnswer(scanner.nextLine())){
                correct++;
            }
            App.clearScreen();
            System.out.println("Aantal goed: " + correct);
        }
        if (correct >= ((questionList.size()-1)/2+1)){ //zodat een examen met 5 vragen pas voldoende is als je 3 vragen goed hebt
            examResult(student, correct, true);
        } else {
            examResult(student, correct, false);
        }
    }

    public void examResult(Student student, int correct, boolean gehaald) {
        if(gehaald){
            student.behaaldeExamens.add(this);
            System.out.println("Gefeliciteerd! Je hebt het examen gehaald.\n" +
            "Je hebt " + correct + " van de " + (questionList.size()) + " vragen goed.");
        } else{
            System.out.println("Helaas... Je hebt het examen niet gehaald.\n" +
            "Je hebt " + correct + " van de " + (questionList.size()) + " vragen goed.\n" +
            "Volgende keer beter!");
        }
    }

    public static void printAllExams(Scanner scanner){
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
