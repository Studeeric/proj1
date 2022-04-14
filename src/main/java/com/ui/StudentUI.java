package com.ui;
import java.util.ArrayList;

import com.logic.Exam;
import com.logic.Student;
public  class StudentUI extends UI {

    private StudentUI(){} //private constructor means no objects can be made of this class

    public static void printNumExist(){
        System.out.println("Studentnummer bestaat al. Kies een ander nummer.");
    }

    public static void printStudentMadeSuc(String name) {
        System.out.println(name + " is toegevoegd aan de student lijst.");
    }

    public static void printStudentRemove(boolean succes) {
        if(succes){
            System.out.println("Student removed");
        }
        else{
            System.out.println("Maak een valide keuze.");
        }  
    }
    
    public static void printNumInv() {
        System.out.println("Studentnummer is niet geldig. Kies een ander nummer");
    }

    /**
     * Asks for student number. True for the question, false for the message that a name hasn't been put in.
     * @param valid
     */
    public static void printAskName(boolean valid) {
        if(valid){
            System.out.println ("Voer je naam in:");
        }
        else{
            System.out.println("Geen naam ingevoerd, probeer het opnieuw.");
        }
    }

    public static void printAskNumber(boolean valid) {
        if(valid){
            System.out.println("Voer je studentnummer (max 8 cijfers) in:");
        }
        else{
            System.out.println("Voer alleen cijfers in.");
        }
    }
    
    public static void printAllStudents(boolean exit){
        if (Student.studentList.isEmpty()){
            System.out.println("Er zijn geen studenten.");
        } else {
            for (int i = 0; i < Student.studentList.size(); i++) {
                System.out.println(ANSI_CYAN + (i+1) + ") " + ANSI_RESET + Student.studentList.get(i).getName());
            }
            if(exit){
                System.out.println(ANSI_RED + "0)" + ANSI_RESET + " Terug naar het hoofdmenu");
            }
        }
    }

    public static void printTryAgain(){
        System.out.println("Indien u wenst te annuleren, voer 0 in.");
        System.out.println("Toets iets anders in om het opnieuw te proberen.");
    }

    public static void printReturnMainMenu(){
        System.out.println("U keert nu terug naar het hoofdmenu.");
    }    
    
    public static void printChooseStudent(){
        System.out.println("Kies een student:");
    }

    public static void printMostPassed(int a, int mostExamPassed, ArrayList<String> nameMostPassed, int n){
        switch(a){
            case(1):
                System.out.println(nameMostPassed.get(0) + " heeft maar liefst " + mostExamPassed + " van de "+Exam.examList.size()+" examens gehaald.");
                break;
            case(2):
                System.out.println("Er zijn "+ nameMostPassed.size() + " Studenten die allemaal "+mostExamPassed+" examens gehaald hebben.");
                System.out.println();
                break;
            case(3):
                System.out.print(nameMostPassed.get(n));
                break;
            case(4):
                System.out.print(", ");
                break;
            case(5):
                System.out.print(" hebben allemaal " + mostExamPassed + " examens behaald.");
                System.out.println();
                break;
            default:
                break;
        }
    }

    public static void printException(Exception e){
        System.out.println("Error in newStudent");
        System.out.println(e);
    }
}
