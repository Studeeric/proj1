package com.logic;


/*
=======Class Explanation=======
This class adds some debug methods for SaveManager & usefull methods for the rest
*/

abstract public class Debug {
    public static void DebugSet(IScanner scanner) {
        checkLoaded(scanner);
        printQuestions();
    }

    public static void printQuestions(){
        for(Exam exam : Exam.examList){
            for(Question question : exam.questionList){
                System.out.println(question.contentsInString());
            }
        }
    }

    public static void checkLoaded(IScanner cloadedIScanner) {
        try{
            checkLoadedLoop : while (true) {
                int userchoiceCheckLoaded = cloadedIScanner.nextInt();
                cloadedIScanner.nextLine();
                switch (userchoiceCheckLoaded) {
                    case 1:
                        for (Student student : Student.studentList){
                            System.out.print(student.getName() + " - " +student.getStudentNumber());
                            for(Exam exam : student.behaaldeExamens){
                                System.out.print(" - "+exam.getName());
                            }
                            System.out.println();
                        }
                        break;
                    case 2:
                        break;
                    case 0:
                        break checkLoadedLoop;
                    default:
                        break;
                }
            }
        }
        finally{}
    }

    public static void wait(int seconds, boolean second){
        try{
            if(second){
                Thread.sleep(seconds*1000);
            }
            else{
                Thread.sleep(seconds);
            }
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public static void testScan(IScanner scanner) {
        System.out.println(scanner.nextInt());
    }
    
}
