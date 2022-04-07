package com.proj1;

public abstract class StudentUI {
    
    private StudentUI(){
    }

    public static void printNumExist(){
        Printer.print("Studentnummer bestaat al. Kies een ander nummer.");
    }

    public static void printStudentMadeSuc(String name) {
        Printer.print(name + "is toegevoegd aan de student lijst.");
    }

    public static void printNumInv() {
        Printer.print("Studentnummer is niet geldig. Kies een ander nummer");
    }
}
