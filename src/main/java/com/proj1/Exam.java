package com.proj1; import java.util.ArrayList; import java.util.Scanner;

public class Exam {
    private String name;
    private String category;
    public static ArrayList<Exam> examList = new ArrayList<>();
    ArrayList<Question> questionList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public Exam(String name, String category){
        this.name = name;
        this.category = category;
        examList.add(this);
    }

    public void startExam(Student student){
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
        if (correct >= ((questionList.size()-1)/2)){
            student.behaaldeExamens.add(this);
            System.out.println("Gefeliciteerd! Je hebt het examen gehaald.\n" +
                                "Je hebt " + correct + " van de " + (questionList.size()) + " vragen goed.");
        } else {
            System.out.println("Helaas... Je hebt het examen niet gehaald.\n" +
                                "Je hebt " + correct + " van de " + (questionList.size()) + " vragen goed.\n" +
                                "Volgende keer beter!");
        }
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
}
