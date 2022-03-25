package com.proj1; import java.util.Scanner; import java.io.IOException;

public class App {
    public static void main( String[] args){
        Scanner scanner = new Scanner(System.in);
        Init.init(false);
        mainMenu(scanner);
        SaveManager.exitSave();
    }

    //mainMenu
    public static void mainMenu(Scanner james) {
        clearScreen();
        mainMenuLoop: while (true) {
            printMainMenu();
            int chooseAction = james.nextInt();
            james.nextLine();
            try{
                switch (chooseAction){
                    case (1):
                        clearScreen();
                        getExams(james);
                        clearScreen();
                        break;
                    case(2):
                        clearScreen();
                        getStudents(james);
                        clearScreen();
                        break;
                    case(3):
                        clearScreen();
                        Student.newStudent(james);
                        break;
                    case(4):
                        clearScreen();
                        Student.deleteStudent(james);
                        break;
                    case(5):
                        clearScreen();
                        startExams(james);
                        break;
                    case(6):
                        clearScreen();
                        studentExamStatus(james);
                        break;
                    case(7):
                        clearScreen();
                        studentExamPassed(james);
                        break;
                    case(8):
                        clearScreen();
                        Student.studentMostPassed();
                        break;
                    case(0):
                        System.out.println("Saving Data.....");
                        break mainMenuLoop;
                    default:
                        System.out.println("No option found, please choose a listed option");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Error in the mainMenu method!"); 
                System.out.println(e);
            }
        }
    }
    //printMainMenu
    private static void printMainMenu() {
        System.out.println("1) Lijst met examens");
        System.out.println("2) Lijst met studenten");
        System.out.println("3) Nieuwe student inschrijven");
        System.out.println("4) Student verwijderen");
        System.out.println("5) Examen afnemen");
        System.out.println("6) Is student geslaagd voor test?"); //non readable reference
        System.out.println("7) Welke examens heeft student gehaald?");
        System.out.println("8) Welke student heeft de meeste examens gehaald?");
        System.out.println("0) Exit");
    }

    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

    //getExams
    private static void getExams(Scanner scanner) {
        for (Exam e : Exam.examList){
            System.out.println(e.getCategory() + " - " + e.getName());
        }
        System.out.println("press return to continue");
        try{
            String getExamsReturn = scanner.nextLine(); // This is just here to wait for input
        }
        finally{}
    }
    //getStudents
    private static void getStudents(Scanner scanner) {
        for (Student e : Student.studentList){
            System.out.println(e.getName());
        }
        System.out.println("press return to continue");
        try{
            String getStudentReturn = scanner.nextLine(); // This is just here to wait for input
        }
        finally{}
    }

     //studentExamStatus
    public static void studentExamStatus(Scanner scanner){
        try{
            System.out.println ("Voer je naam in:");
            String studentName = scanner.nextLine();
            System.out.println("Voer je studentnummer in");
            int studentNumber = scanner.nextInt();
            System.out.println("Examens beschikbaar:");
            int counter = 1;
            for(Exam exam : Exam.examList){
                System.out.println(counter+")"+exam.getName());
                counter++;
            }
            System.out.println ("Voer het nunmmer van het examen in:");
            int examNummer = scanner.nextInt();
            examNummer = examNummer - 1;
            System.out.println (Exam.getExam(examNummer));
        }
        catch(Exception e){
            System.out.println("Error in studentExamStatus!");
            System.out.println(e);
        }
    }

    //studentExamPassed
    public static void studentExamPassed(Scanner scanner){
        try{
            System.out.println ("Voer je naam in:");
            String studentName = scanner.nextLine();
            System.out.println("Voer je studentnummer in:");
            int studentNumber = scanner.nextInt();
            System.out.println("Examens beschikbaar:");
            int counter = 1;
            for(Exam exam : Exam.examList){
                System.out.println(counter+")"+exam.getName());
                counter++;
            }
            System.out.println ("Voer de naam van het examen in:");
            String examName = scanner.nextLine();
        }
        catch(Exception e){
            System.out.println("Error in studentExamPassed!");
            System.out.println(e);
        }
    }

    //StartExams
    public static void startExams(Scanner scanner){
        try{
            startExamsLoop:while(true){
                System.out.println("Geef je StudentNummer:");
                int userInput = scanner.nextInt();
                scanner.nextLine();
                startExamsFindStudentLoop: for (int i=0; i < Student.studentList.size(); i++){
                    if(userInput == Student.studentList.get(i).getStudentNumber()){
                        studentGegevensAanwezig(Student.studentList.get(i));    
                    }
                    if (i==(Student.studentList.size()-1)&&userInput != Student.studentList.get(i).getStudentNumber()){
                        studentGegevensAfwezigMessage();
                        int studentNotFoundKeuze = scanner.nextInt();
                        scanner.nextLine();
                        try{
                            switch(studentNotFoundKeuze){
                                case 1:
                                    break startExamsFindStudentLoop;//NO. No recursion
                                case 2:
                                    Student.newStudent(scanner);
                                    break startExamsFindStudentLoop;
                                case 3: 
                                    break startExamsLoop;
                                default:
                                    System.out.println("Verkeerde optie. Ga terug naar main menu.");
                                    break startExamsLoop;
                            }    
                        } 
                        finally{}
                    }
                }
            }

            System.out.println("Press enter to continue");
            try{
                String returnMenu = scanner.nextLine(); // This is just here to wait for input
            }
            finally{}
        }
        finally{}
    
        
    }

    private static void studentGegevensAanwezig(Student student){
        try(Scanner scanner = new Scanner(System.in)){
            
            System.out.println("Kies uw examen:");
            for (int i = 0; i < Exam.examList.size(); i++) {
                System.out.println(i+1 + ") " + Exam.examList.get(i).getName() + " - " + Exam.examList.get(i).getCategory());
            }
            int keuze = scanner.nextInt();
            scanner.nextLine();

            if (keuze > Exam.examList.size() || keuze < 0){
                System.out.println("Wat denk je zelf, mafklapper? Je kan niet een ander getal geven dan dat jou gepresenteerd is.");
            } else {
                Exam.examList.get(keuze).startExam(student);
            }
        }
        catch(Exception e){
            System.out.println("Error in studentGegevensAanwezig");
            System.out.println(e);
        }
    }

    private static void studentGegevensAfwezigMessage(){
        System.out.println("Studentgegevens kloppen niet, of bestaan niet.");
        System.out.println("Kies een van de volgende opties:");
        System.out.println("1) Probeer opnieuw");
        System.out.println("2) Nieuwe student aanmaken");
        System.out.println("3) Terug naar hoofdmenu");
    }
  
/*
    private void maakNieuweStudentAan(){
        Scanner maNiStAaInput = new Scanner(System.in);

        System.out.println("Wat is je naam?");
        String naam = maNiStAaInput.nextLine();

        System.out.println("Wat is je studentnummer?");
        int studentnummer = maNiStAaInput.nextInt();

        Student student = new Student(naam, studentnummer);

        System.out.println(student.getName() +" is toegevoegd aan de student lijst.");
        maNiStAaInput.close();
    }
    */
}
