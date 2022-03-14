package com.proj1; import java.util.Scanner; import java.io.IOException;


public class App {
    public static void main( String[] args){
        mainMenu();
    }

    public static void mainMenu() {
        clrscr();
        printMenu();
        Scanner james = new Scanner(System.in);
        int chooseAction = james.nextInt();
        try{
            switch (chooseAction){
                case (1):
                    getExams();
                    mainMenu();
                case(2):
                    getStudents();
                    mainMenu();
                case(3):
                    newStudent();
                    mainMenu();
                case(4):
                    deleteStudent();
                    mainMenu();
                case(5):
                    startExams();
                    mainMenu();
                case(6):
                    studentExamStatus();
                    mainMenu();
                case(7):
                    studentExamPassed();
                    mainMenu();
                case(8):
                    studentMostPassed();
                    mainMenu();
                case(0):
                    System.out.println("exiting now.");
                    break;
                default:
                    System.out.println("No option found, please choose a listed option");
                    mainMenu();
            }
        }finally {}
        james.close();

        
    }

    public static void printMenu() {
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor test?");
        System.out.println("7) Welke examens heeft student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Exit");
    }

    public static void clrscr(){
        //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    //burton's toevoegingen vanaf hier
    public void startExams(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Geef je studentgegevens.");
        String userInput = scanner.nextLine();

        for (int i=0; i <studentList.size(); i++){
            if(userInput != studentList.get(i).getName()){
                studentGegevensAfwezigMessage();
                
                int sGAkiesmenu = scanner.nextInt();

                try{
                    switch(sGAkiesmenu){
                        case 1:
                            startExams();//deze methode opnieuw
                            break;
                        case 2:
                            maakNieuweStudentAan();
                            startExams();//deze methode opnieuw
                            break;
                        case 3:
                            mainMenu();
                            break;
                        default:
                            System.out.println("Verkeerde optie. Ga terug naar main menu.");
                            mainMenu();
                    }    
                } 
                
                break;
            } else {
                studentGegevensAanwezig();    
            }

        }
    }

    private void studentGegevensAanwezig(){
        Scanner charles = new Scanner(System.in);
        System.out.println("Kies een van de volgende examens.");
        for (int n = 0; n < examList.size(); n++){
            System.out.print(n+") " + examList.get(n).getName() + " " + examList.get(n).getCategory());
        }
        int inputStudentGegevensAanwezig = charles.nextInt();
        try{
        startExam(examList.get(inputStudentGegevensAanwezig).getName());
        } catch (exception e){
            System.out.println("Wat denk je zelf, mafklapper? Je kan niet een ander getal geven dan dat jou gepresenteerd is.");
        }
    }

    private void studentGegevensAfwezigMessage(){
        System.out.println("Studentgegevens kloppen niet, of bestaan niet.");
        System.out.println("Kies een van de volgende opties:");
        System.out.println("1) Probeer opnieuw");
        System.out.println("2) Nieuwe student aanmaken");
        System.out.pritnln("3) Terug naar hoofdmenu");
    }

    private void maakNieuweStudentAan(){
        Scanner maNiStAaInput = new Scanner(System.in);

        System.out.println("Wat is je naam?");
        String naam = maNiStAaInput.nextLine();

        System.out.println("Wat is je studentnummer?");
        int studentnummer = maNiStAaInput.nextInt();

        Student student = new student(naam, studentnummer);

        System.out.println("Je bent toegevoegd aan de student lijst.");
        maNiStAaInput.close();

    }
}


