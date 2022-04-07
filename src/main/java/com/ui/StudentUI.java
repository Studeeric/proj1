package com.ui;

public abstract class StudentUI extends UI {
    
    private StudentUI(){
    }

    public static void printNumExist(){
        printer.print("Studentnummer bestaat al. Kies een ander nummer.");
    }

    public static void printStudentMadeSuc(String name) {
        printer.print(name + "is toegevoegd aan de student lijst.");
    }

    public static void printNumInv() {
        printer.print("Studentnummer is niet geldig. Kies een ander nummer");
    }
}
