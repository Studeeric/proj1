package com.ui;

import java.util.ArrayList;

import com.logic.Exam;
import com.logic.Question;

public abstract class ExamUI extends UI{
  
  private ExamUI(){}//private constructor means no objects can be made of this class

  public static void printAmountCorrect(int correct){
    System.out.println(
      "Aantal goed: " + ANSI_GREEN + correct + ANSI_RESET
    );
  }

  public static void printAmountOfTotalCorrect(int correct, int total){
    System.out.println(
      "Je hebt " + ANSI_GREEN + correct + ANSI_RESET + " van de " + ANSI_RED + total + ANSI_RESET + " vragen goed."
    );
  }

  public static void printSuccesfulExam(int correct, int total){
    System.out.println(
      "Gefeliciteerd!" + "\n" +
      "Je hebt het examen gehaald!" + "\n"
    );
    printAmountOfTotalCorrect(correct, total);
  }

  public static void printFailedExam(int correct, int total){
    System.out.println(
      "Helaas... Je hebt het examen niet gehaald."
    );
    printAmountOfTotalCorrect(correct, total);
    System.out.println(
      "Volgende keer beter!"
    );
  }

  public static void printQuestion(int i, ArrayList<Question> currentQuestions) {
    System.out.println(
      "Vraag " + (i+1) + ":" + "\n" +
      currentQuestions.get(i).questionPrompt
      );
  }

  public static void printQuestionChoices(int i, int j, ArrayList<Question> currentQuestions) {
    System.out.println(
      j+1 + ") " + currentQuestions.get(i).askQuestion().get(j)
      );
  }

  public static void printNoExams(){
      System.out.println(
        "Er zijn momenteel geen examens beschikbaar."
      );
  }

  public static void printExam(int i, ArrayList<Exam> examList) {
    System.out.println(
      i+1 + ") " + examList.get(i).getName() + " - " + examList.get(i).getCategory()
      );
  }

  public static void printExamColourCoded(String line, boolean passed) {
    if(passed)
      System.out.println(ANSI_GREEN+line+ANSI_RESET);
    else
      System.out.println(ANSI_RED+line+ANSI_RESET);
  }
}
