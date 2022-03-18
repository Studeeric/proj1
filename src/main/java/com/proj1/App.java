package com.proj1; import java.util.Scanner; import java.io.IOException;

public class App {
    public static void main( String[] args){
        mainMenu();
    }
    //mainMenu
    public static void mainMenu() {
        clearScreen();
        Scanner james = new Scanner(System.in);
        mainMenuLoop: while (true) {
            printMainMenu();
            int chooseAction = james.nextInt();
            james.nextLine();
            try{
                switch (chooseAction){
                    case (1):
                        clearScreen();
                        getExams(james);
                        break;
                    case(2):
                        clearScreen();
                        getStudents(james);
                        break;
                    case(3):
                        clearScreen();
                        Student.newStudent();
                        break;
                    case(4):
                        clearScreen();
                        Student.deleteStudent();
                        break;
                    case(5):
                        clearScreen();
                        startExams();
                        break;
                    case(6):
                        clearScreen();
                        studentExamStatus();
                        break;
                    case(7):
                        clearScreen();
                        studentExamPassed();
                        break;
                    case(8):
                        clearScreen();
                        Student.studentMostPassed();
                        break;
                    case(0):
                        System.out.println("exiting now.");
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

    private static void printMainMenu() {
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
    public static void studentExamStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Voer je naam en studentnummer in:");
        String studentName = scanner.nextLine();
        int studentNumber = scanner.nextInt();
        System.out.println("Examens beschikbaar:");
        int counter = 1;
        for(Exam exam : Exam.examList){
            System.out.println(counter+")"+exam.getName());
            counter++;
        }
        System.out.println ("Voer de naam van het examen in:");
        String examName = scanner.nextLine();


        scanner.close();
    }

    //studentsExamPassed
    public static void studentExamPassed(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Voer je naam en studentnummer in:");
        String studentName = scanner.nextLine();
        int studentNumber = scanner.nextInt();
        System.out.println("Examens beschikbaar:");
        int counter = 1;
        for(Exam exam : Exam.examList){
            System.out.println(counter+")"+exam.getName());
            counter++;
        }
        System.out.println ("Voer de naam van het examen in:");
        String examName = scanner.nextLine();


        scanner.close();
    }

    //burton's toevoegingen vanaf hier
    //StartExams
    public static void startExams(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geef je StudentNummer.");
        int userInput = scanner.nextInt();

        for (int i=0; i < Student.studentList.size(); i++){
            if(userInput != Student.studentList.get(i).getStudentNumber()){
                studentGegevensAfwezigMessage();
                
                int sGAkiesmenu = scanner.nextInt();

                try{
                    switch(sGAkiesmenu){
                        case 1:
                            startExams();//deze methode opnieuw
                            break;
                        case 2:
                            Student.newStudent();
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
                finally{}
                break;
            } else {
                studentGegevensAanwezig();    
            }
            scanner.close();
        }
    }

    private static void studentGegevensAanwezig(){
        Scanner charles = new Scanner(System.in);
        System.out.println("Kies een van de volgende examens.");
        for (int n = 0; n < Exam.examList.size(); n++){
            System.out.print(n+") " + Exam.examList.get(n).getName() + " " + Exam.examList.get(n).getCategory());
        }
        int inputStudentGegevensAanwezig = charles.nextInt();
        try{
        //Exam.startExam(Exam.examList.get(inputStudentGegevensAanwezig).getName()); //Burton please fix.
        } catch (Exception e){
            System.out.println("Wat denk je zelf, mafklapper? Je kan niet een ander getal geven dan dat jou gepresenteerd is.");
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


