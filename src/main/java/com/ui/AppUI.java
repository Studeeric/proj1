package com.ui;

/**The app does this */
public abstract class AppUI extends UI{

  private AppUI(){
  }

  /**The method printmainmenu does this */
  public static void printMainMenu(){
    printer.print
    (
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

  public static void printSaveMessage(){
    System.out.println("Saving Data.....");
  }

  public static void printChooseValidOption(int option){
    switch(option){
      case 1:
        System.out.println("Invalid option. Please choose a listed option");
      case 2:
        System.out.println("Voer een geldig nummer in met alleen cijfers.");
      case 3:
        System.out.println("Wat denk je zelf, mafklapper? Dat examen bestaat helemaal niet.");
      case 4:
        System.out.println("Student is niet gevonden. Keer terug naar het hoofdmenu");
      case 5:
        System.out.println(
        "Wat denk je zelf, mafklapper? Je kan niet een ander getal geven dan dat jou gepresenteerd is.");
      case 6:
        System.out.println("Optie bestaat niet. Keer terug naar main menu.");
    }
  }

  public static void voerXIn(String object){
    switch(object){
      case "studentnr":
        System.out.println("Voer je studentnummer in:");
      case "examnr":
        System.out.println("Voer het nummer van het examen in:");
      default:
        System.out.println("Wrong input into voerXIN() at App.java"); 
    }
  }

  public static void studentGegevensAfwezigMessage() {
    System.out.println("Studentgegevens kloppen niet, of bestaan niet.");
    System.out.println("Kies een van de volgende opties:");
    System.out.println("1) Probeer opnieuw");
    System.out.println("2) Nieuwe student aanmaken");
    printOptionGoBackToMainMenu();
  }

  public static void errorMessageApp(Exception e, String method){
    System.out.println("Error in method " + method + " in class App");
    System.out.println(e);
  }

  public static void studentHeeftExamenWelNietGehaald(boolean welniet, String exam){
    if(welniet){
      System.out.println("De student heeft het examen \"" +exam +"\" gehaald.");
    } else {
      System.out.println("De student heeft het examen \"" + exam + "\" niet gehaald.");
    }
  }

  public static void printOptionGoBackToMainMenu(){
    System.out.println("0) Keer terug naar het hoofdmenu");
  }
}
