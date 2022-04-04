package com.proj1;import java.util.Scanner;

public class Debug {
    public static void DebugSet(Scanner scanner) {
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

    public static void checkLoaded(Scanner cloadedScanner) {
        try{
            checkLoadedLoop : while (true) {
                int userchoiceCheckLoaded = cloadedScanner.nextInt();
                cloadedScanner.nextLine();
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
                        for(Exam exam : Exam.examList){
                            System.out.println(exam.getName() + " - "+exam.getCategory());
                            /*for(Question question : exam.getQuestionList()){
                                for(String content : question.questionContents){
                                    System.out.println(content);
                                }
                            }
                            */
                        }
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
}
