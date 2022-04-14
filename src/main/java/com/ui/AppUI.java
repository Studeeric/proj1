package com.ui;

//The app does this
public abstract class AppUI extends UI{
  
  private AppUI(){} //private constructor means no objects can be made of this class

  //The method printmainmenu does this
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

  public static void printSaveMessage(){
    System.out.println("Saving Data.....");
  }

  public static void printChooseValidOption(int option){
    /*integer option zit hardcoded in App.java . Zo kunnen we 1 methode gebruiken voor meerdere printlines. Ook zijn er in theorie meerdere
    uses per case mogelijk.*/
    switch(option){
      case 1:
        System.out.println("Invalid option. Please choose a listed option");
        break;
      case 2:
        System.out.println("Voer een geldig nummer in met alleen cijfers.");
        break;
      case 3:
        System.out.println("Wat denk je zelf, mafklapper? Dat examen bestaat helemaal niet.");
        break;
      case 4:
        System.out.println("Student is niet gevonden. Keer terug naar het hoofdmenu");
        break;
      case 5:
        System.out.println(
        "Wat denk je zelf, mafklapper? Je kan niet een ander getal geven dan dat jou gepresenteerd is.");
        break;
      case 6:
        System.out.println("Optie bestaat niet. Keer terug naar main menu.");
        break;
    }
  }

  public static void voerXIn(String object){ //Burton, for the love of god don't forget the break; Switch cases fall through
                                              //Sorry Wouter, zal het niet meer vergeten :(
    /*string object zit hardcoded in App.java . Zo kunnen we 1 methode gebruiken voor meerdere printlines. Ook zijn er in theorie meerdere
    uses per case mogelijk.*/
    switch(object){
      case "studentnr":
        System.out.println("Voer je studentnummer in:");
        break;
      case "examnr":
        System.out.println("Voer het nummer van het examen in:");
        break;
      default:
        System.out.println("Wrong input into voerXIN() at App.java");
        break; 
    }
  }

  public static void studentGegevensAfwezigMessage(){
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
  public static void printNoExamsPassed(){
    System.out.println("De student heeft helaas geen examens gehaald.");
  }

  public static void printExamStudentExamPassed(int a, String naam, String category){
    System.out.println(a + ") " + naam + " - " + category);
  }
  public static void printExamenBeschikbaar(){
    System.out.println("Examens beschikbaar");
    
  }
  public static void printExamenColourCodes(){
    System.out.println(ANSI_GREEN +"Gehaald "+ANSI_RESET+ANSI_RED+" Gefaald"+ANSI_RESET);
  }

  public static void printGoBackToMainMenu(){
    System.out.println("U keert terug naar het hoofdmenu.");
  }

  public static void printPressReturnToContinue(){
    System.out.println("Press return to continue.");
  }
  public static void printExamPassed(boolean gehaald, int nummer, int aantal) {
    if(gehaald)
      clearScreen();
      System.out.println("Student "+ nummer+" heeft " + aantal + " Examens gehaald");
  }
  public static void printStudentNotFound() {
    System.out.println("StudentNumber unknown, please enter a valid number");
  }
}
