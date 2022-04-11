package com.logic; import java.util.ArrayList;

import com.ui.StudentUI;

public class Student {
    private String name;
    private int studentNumber;
    public static ArrayList<Student> studentList = new ArrayList<>();
    public ArrayList<Exam> behaaldeExamens = new ArrayList<>();

    public Student(String name, int studentNumber){
        this.name = name;
        this.studentNumber = Math.abs(studentNumber);
        studentList.add(this);
    }

    public String getName(){
        return this.name;
    }

    public int getStudentNumber(){
        return this.studentNumber;
    }

    public static void newStudent(IScanner scanner){
        try{
            newStudentloop1: while(true){
                String naam;
                newStudentloop2:while(true){
                    StudentUI.printAskName(true);
                    naam = scanner.nextLine();
                    if (naam.equals("")){
                        StudentUI.printAskName(false);
                    }
                    else{
                        break newStudentloop2;
                    }
                }
                naam = naam.replace("\n", "");
                int nummer = studentNumberStrToInt(scanner);
                checkStudentNumber(nummer, naam, scanner);  
                Student student = new Student (naam, nummer);
                StudentUI.printStudentMadeSuc(student.getName());
                App.pauseMenu(scanner); 
                break newStudentloop1; 
            }        
        }
        catch(Exception e){
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }
    
    public static void checkStudentNumber (int nummer, String naam, IScanner scanner){
        int nummer2;
        try{
        for (Student e : Student.studentList){
            if (e.getStudentNumber() == nummer){
                    StudentUI.printNumExist();
                    App.pauseMenu(scanner);
                    App.clearScreen();
                    nummer2 = studentNumberStrToInt(scanner);
                    checkStudentNumber(nummer2, naam, scanner);
                }
            }
            if (nummer <= 0 ){
                StudentUI.printNumInv();
                App.pauseMenu(scanner);
                App.clearScreen();
                nummer2 = studentNumberStrToInt(scanner);
                checkStudentNumber(nummer2, naam, scanner);
            }
        }
        catch(Exception e){
            System.out.println("Error in newStudent");
            System.out.println(e);
        }
    }

    public static int studentNumberStrToInt(IScanner scanner){
        while(true){
            try{
                StudentUI.printAskNumber(true);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException s){
                StudentUI.printAskNumber(false);
                App.pauseMenu(scanner);
                App.clearScreen();
            }    
        }
    }

   
    
    public static void deleteStudent(IScanner scanner){
        while (true){
            App.clearScreen();
            StudentUI.printAllStudents(true);
            System.out.println("Kies een student:");
            int userRemoveStudentChoice;
            try {
                userRemoveStudentChoice = Integer.parseInt(scanner.nextLine());
                if (userRemoveStudentChoice == 0){
                    break;
                } else {
                    Student.studentList.set((userRemoveStudentChoice-1),null);
                    Student.studentList.remove(userRemoveStudentChoice-1);
                    StudentUI.printStudentRemove(true);
                    App.pauseMenu(scanner);
                }
            } catch (NumberFormatException e){
                StudentUI.printStudentRemove(false);
                App.pauseMenu(scanner);
            }
        }    
    }

    public static void studentMostPassed(IScanner scanner){

        int meesteNrBehaaldeExamens = 0;
        ArrayList<String> namenStudentenMetMostPassed = new ArrayList<>();

        for (int i = 0; i < studentList.size(); i++){
            if (meesteNrBehaaldeExamens < studentList.get(i).behaaldeExamens.size()){
                meesteNrBehaaldeExamens = studentList.get(i).behaaldeExamens.size();
            }
        }

        for (int i = 0; i < studentList.size(); i++){
            if (meesteNrBehaaldeExamens == studentList.get(i).behaaldeExamens.size()){
                namenStudentenMetMostPassed.add(studentList.get(i).getName());
            }
        }

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
            System.out.print("hebben allemaal " + meesteNrBehaaldeExamens + " examens behaald.");
            System.out.println("");
        }
        
        App.pauseMenu(scanner);
    }
}
