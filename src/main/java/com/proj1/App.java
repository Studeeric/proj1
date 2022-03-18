package com.proj1; import java.util.Scanner; import java.io.IOException;

public class App {
    public static void main( String[] args){
        init();
        mainMenu();
    }
    //mainMenu
    public static void mainMenu() {
        clearScreen();
        printMainMenu();
        Scanner james = new Scanner(System.in);
        int chooseAction = james.nextInt();
        james.nextLine();
        try{
            switch (chooseAction){
                case (1):
                    getExams(james);
                    mainMenu();
                case(2):
                    getStudents(james);
                    mainMenu();
                case(3):
                    Student.newStudent();
                    mainMenu();
                case(4):
                    Student.deleteStudent();
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
                    Student.studentMostPassed();
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

    public static void printMainMenu() {
        System.out.println(Exam.examList.get(0).questionList.get(0).askQuestion());
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

        System.out.println("Geef je StudentNummer:");
        int userInput = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i < Student.studentList.size(); i++){
            if(userInput != Student.studentList.get(i).getStudentNumber()){
                studentGegevensAfwezigMessage();
                
                int sGAkiesmenu = scanner.nextInt();
                scanner.nextLine();

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
                studentGegevensAanwezig(Student.studentList.get(i));    
            }
            scanner.close();
        }
    }

    private static void studentGegevensAanwezig(Student student){
        Scanner charles = new Scanner(System.in);
        System.out.println("Kies een van de volgende examens.");
        for (int n = 0; n < Exam.examList.size(); n++){
            System.out.print(n+") " + Exam.examList.get(n).getName() + " - " + Exam.examList.get(n).getCategory()+"\n");
        }
        int input = charles.nextInt();
        charles.nextLine();
        if (input > Exam.examList.size()-1 || input < 0){
            System.out.println("Wat denk je zelf, mafklapper? Je kan niet een ander getal geven dan dat jou gepresenteerd is.");
        } else{
            Exam.examList.get(input).startExam(student);
        }
        charles.close();
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


    private static void init(){
        Exam rekenen = new Exam("Rekenen voor beginners", "Rekenen");
        rekenen.addQuestion(new Question("Wat is 2 + 2?\n A) 1\n B) 2\n C) 3\n D) 4\n", "D"));
        rekenen.addQuestion(new Question("Wat is 2 - 2?\n A) 0\n B) 1\n C) 2\n D) 3\n", "A"));
        rekenen.addQuestion(new Question("Wat is 1 + 1?\n A) 1\n B) 2\n C) 3\n D) 4\n", "B"));
        rekenen.addQuestion(new Question("Wat is 3 x 2?\n A) 4\n B) 5\n C) 6\n D) 8\n", "C"));
        rekenen.addQuestion(new Question("Wat is 610 x 410 / 5104?\n A) 2\n B) 55.6\n C) 50.2\n D) 49.0\n", "D"));

        Exam tekenen = new Exam("Kleuren voor beginners", "Tekenen");
        tekenen.addQuestion(new Question("Wat krijg je als je blauw en geel mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "A"));
        tekenen.addQuestion(new Question("Wat krijg je als je rood en wit mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "B"));
        tekenen.addQuestion(new Question("Wat krijg je als je blauw en rood mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "C"));
        tekenen.addQuestion(new Question("Wat krijg je als je rood en geel mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "D"));

        new Student("Eric", 21146632); // FF mijzelf toegevoegd om 1 standaard student er in te hebben, feel free om jezelf ook toe te voegen.
    }

}

