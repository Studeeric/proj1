package com.ui;

/*The app does this*/
public abstract class AppUI extends UI{
  private AppUI(){
  }

  /*The method printmainmenu does this */
  public static void printMainMenu(){
    UI.clearScreen();
    printer.print(
      ANSI_CYAN + "1)" + ANSI_RESET + " Lijst met examens" + "\n" +
      ANSI_CYAN + "2)" + ANSI_RESET + " Lijst met studenten" + "\n" +
      ANSI_CYAN + "3)" + ANSI_RESET + " Nieuwe student inschrijven" + "\n" +
      ANSI_CYAN + "4)" + ANSI_RESET + " Student verwijderen" + "\n" +
      ANSI_CYAN + "5)" + ANSI_RESET + " Examen afnemen" + "\n" +
      ANSI_CYAN + "6)" + ANSI_RESET + " Is student geslaagd voor test?" + "\n" +
      ANSI_CYAN + "7)" + ANSI_RESET + " Welke examens heeft student gehaald?" + "\n" +
      ANSI_CYAN + "8)" + ANSI_RESET + " Welke student heeft de meeste examens gehaald?" + "\n" +
      ANSI_CYAN + "9)" + ANSI_RESET + " Manage Examens" + "\n" +
      ANSI_RED + "0) Exit" + ANSI_RESET
    );
  }
}
