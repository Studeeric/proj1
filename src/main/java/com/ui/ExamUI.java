package com.ui;

public abstract class ExamUI extends UI{
  
  private ExamUI(){ 
  }

  public static void amountCorrect(int correct){
    printer.print
    (
      "Aantal goed: " + ANSI_GREEN + correct + ANSI_RESET
    );
  }

  public static void amountOfTotalCorrect(int correct, int total){
    printer.print
    (
      "Je hebt " + ANSI_GREEN + correct + ANSI_RESET + " van de " + ANSI_RED + total + ANSI_RESET + " vragen goed."
    );
  }

  public static void succesfulExam(int correct, int total){
    printer.print
    (
      "Gefeliciteerd!" + "\n" +
      "Je hebt het examen gehaald!" + "\n"
    );
    amountOfTotalCorrect(correct, total);
  }

  public static void failedExam(int correct, int total){
    printer.print
    (
      "Helaas... Je hebt het examen niet gehaald."
    );
    amountOfTotalCorrect(correct, total);
    printer.print
    (
      "Volgende keer beter!"
    );
  }
}
