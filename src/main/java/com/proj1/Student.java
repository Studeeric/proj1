package com.proj1; import java.util.Scanner; import java.util.ArrayList;

public class Student {
    private String name;
    private int studentNumber;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public ArrayList<Exam> behaaldeExamens = new ArrayList<>();
    //private Exam examen;

    public Student(String name, int studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
        studentList.add(this);
    }
    public String getName(){
        return this.name;
    }

    public int getStudentNumber(){
        return this.studentNumber;
    }

    public static void newStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Voer je naam:");
        String naam = scanner.nextLine();
        naam = naam.replace("\n", "");
        System.out.println("Voer je studentnummer in:");
        int nummer = scanner.nextInt();
        Student student = new Student (naam, nummer);
        System.out.println(student.getName() + " is toegevoegd aan de student lijst.");
    }
    
    public static void deleteStudent(){
        Scanner scanner = new Scanner(System.in);
        /*
        System.out.println ("Voer je naam:");
        String naam = scanner.nextLine();
        naam = naam.replace("\n", "");
        System.out.println("Voer je studentnummer in:");
        int nummer = scanner.nextInt();
        scanner.nextLine();
        */
        int counter = 1;
        for (Student e : Student.studentList){
            System.out.println(counter+") "+e.getName());
            counter++;
            /*
            if (e.getName() == naam && e.getStudentNumber() == nummer){
                Student.studentList.remove(e);
                return "Student succesvol verwijderd.";
            }
            */
            //This just doesn't work. Prob because \n or smth is causing the typed name to misreport.
            //So I changed it to a completly insecure version, Enjoy!
        }
        System.out.println("Kies een student");
        int userRemoveStudentChoice = scanner.nextInt();
        scanner.nextLine();
        Student.studentList.remove(userRemoveStudentChoice-1);
        System.out.println("Student removed");
        System.out.println("Press return to continue");
        scanner.nextLine();
    }

    public static void studentMostPassed (){
        int totaal = 0;
        int studentNR = 0;
        for (int i = 0; i < studentList.size(); i++){
            if (totaal < studentList.get(i).behaaldeExamens.size()){
                totaal = studentList.get(i).behaaldeExamens.size();
                studentNR = i;
            }
        }
        System.out.println(studentList.get(studentNR).getName() + " heeft maar liefst " + totaal + " examens gehaald.");
    }
}
