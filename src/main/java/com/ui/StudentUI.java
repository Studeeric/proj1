package com.ui;
import com.logic.Student;
public abstract class StudentUI extends UI {
    
    private StudentUI(){
    }

    public static void printNumExist(){
        printer.print("Studentnummer bestaat al. Kies een ander nummer.");
    }

    public static void printStudentMadeSuc(String name) {
        printer.print(name + "is toegevoegd aan de student lijst.");
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
            System.out.println("Voer je studentnummer in:");
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
}
