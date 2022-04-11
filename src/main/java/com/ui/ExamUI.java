package com.ui;

import java.util.ArrayList;

import com.logic.Exam;
import com.logic.Question;

public abstract class ExamUI extends UI{
  
  private ExamUI(){ 
  }

  public static void printAmountCorrect(int correct){
    printer.print
    (
      "Aantal goed: " + ANSI_GREEN + correct + ANSI_RESET
    );
  }

  public static void printAmountOfTotalCorrect(int correct, int total){
    printer.print
    (
      "Je hebt " + ANSI_GREEN + correct + ANSI_RESET + " van de " + ANSI_RED + total + ANSI_RESET + " vragen goed."
    );
  }

  public static void printSuccesfulExam(int correct, int total){
    printer.print
    (
      "Gefeliciteerd!" + "\n" +
      "Je hebt het examen gehaald!" + "\n"
    );
    printAmountOfTotalCorrect(correct, total);
  }

  public static void printFailedExam(int correct, int total){
    printer.print
    (
      "Helaas... Je hebt het examen niet gehaald."
    );
    printAmountOfTotalCorrect(correct, total);
    printer.print
    (
      "Volgende keer beter!"
    );
  }

  public static void printQuestion(int i, ArrayList<Question> currentQuestions) {
    printer.print(
      "Vraag " + (i+1) + ":" + "\n" +
      currentQuestions.get(i).questionPrompt
      );
  }

  public static void printQuestionChoices(int i, int j, ArrayList<Question> currentQuestions) {
    printer.print(
      j+1 + ") " + currentQuestions.get(i).askQuestion().get(j)
      );
  }

  public static void printNoExams(){
      printer.print("Er zijn momenteel geen examens beschikbaar.");
  }

  public static void printExam(int i, ArrayList<Exam> examList) {
    printer.print(i+1 + ") " + examList.get(i).getName() + " - " + examList.get(i).getCategory());
  }
}
