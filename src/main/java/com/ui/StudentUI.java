package com.ui;
import java.util.ArrayList;

import com.logic.Student;
public  class StudentUI extends UI {
    

    public static void printNumExist(){
        printer.print("Studentnummer bestaat al. Kies een ander nummer.");
    }

    public static void printStudentMadeSuc(String name) {
        printer.print(name + " is toegevoegd aan de student lijst.");
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
        printer.print("Studentnummer is niet geldig. Kies een ander nummer");
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
                System.out.println((i+1) + ") " + Student.studentList.get(i).getName());
            }
            if(exit){
                System.out.println("0) Terug naar het hoofdmenu");
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

    public static void printMostPassed(int meesteNrBehaaldeExamens, ArrayList<String> namenStudentenMetMostPassed){
        if (namenStudentenMetMostPassed.size()==1){
            System.out.println(namenStudentenMetMostPassed.get(0) + " heeft maar liefst " + meesteNrBehaaldeExamens + " examens gehaald.");   
        } else {
            System.out.println("Er zijn "+ namenStudentenMetMostPassed.size() + " Studenten die allemaal de meeste examens gehaald hebben.");
            System.out.println("");
            for (int n = 0; n < namenStudentenMetMostPassed.size(); n++){
                System.out.print(namenStudentenMetMostPassed.get(n));
                if (n < (namenStudentenMetMostPassed.size()-1)){
                    System.out.print(", ");
                }
            }
            System.out.print(" hebben allemaal " + meesteNrBehaaldeExamens + " examens behaald.");
            System.out.println("");
        }

    }

    public static void printException(Exception e){
        System.out.println("Error in newStudent");
        System.out.println(e);
    }
}
