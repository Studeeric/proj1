package com.proj1; import java.util.Scanner;import java.io.IOException; import java.io.File; import java.io.FileWriter; import java.util.ArrayList;

public abstract class SaveManager {

    //Edited version of my accidental file editor + loader methods
    private SaveManager(){} //private constructor means no objects can be made of this class
    public static ArrayList<String> readFile(String fileName, boolean silent){ //
        File savefile = new File(fileName);
        ArrayList<String> saveFileContents = new ArrayList<>();
        try {
            Scanner james = new Scanner(savefile);
            while (james.hasNextLine()) {
                String contents = james.nextLine();
                saveFileContents.add(contents);
            }
            if(!silent){
                int counter = 1;
                for (String entry : saveFileContents){
                    System.out.println(counter + ") " + entry);
                    counter++;
                }
                System.out.println("=========================");
            }
            james.close();
        }
        catch (Exception e) {
            //Debug remove in production
            System.out.println("An error occurred in method readFile().");
            e.printStackTrace();
        }
        return saveFileContents;
    }

    public static boolean cleanFile(File savefile,boolean makefile) {
        try{
            if(savefile.delete()){
                return savefile.createNewFile();
            }
            else if(makefile){
                return savefile.createNewFile();
            }
            return false;
        }
        catch(IOException e){
            System.out.println("A error has occured in method cleanFile"); 
            return false;
        }
    }

    public static boolean isFileValid(String fileName) {
        File savefile = new File(fileName);
        //Check if the output file exists and if it doesn't, makes one
        try{
            if (savefile.createNewFile()){
                System.out.println("Made new savefile: " + savefile.getName());
            }
            else{
                System.out.println("Using existing savefile");
            }
            return true;
        }
        catch(IOException e){
            System.out.println("Error in method isFileValid!");
            System.out.println(e);
            return false;
        }
        
    }

    public static ArrayList<String> findSaveFiles(){
        File folder = new File(Init.dir+"/database/");
        ArrayList<String> dataFiles = new ArrayList<>();
        File[] fileList = folder.listFiles();

        for (File file : fileList) {
            if (file.isFile()) {
                if(file.getName().endsWith(".Wdf")){
                    dataFiles.add(file.getName());
                }
            }
        }
        return dataFiles;
        
    }

    public static void loadSaveFile(String fileName){
        //Exam rekenen = new Exam("Rekenen voor beginners", "Rekenen");
        //Exam tekenen = new Exam("Kleuren voor beginners", "Tekenen");
        ArrayList<String> fileContents = new ArrayList<String>(readFile(fileName,true));
        try{
            for (String entries : fileContents){
                String[] orders = entries.split(":");
                if(!orders[0].startsWith("#")){ //Use # for comments in the savefile
                    switch(orders[0]){
                        case("exam"):
                        case("Exam"):
                            if(orders[1].equals("newExam")){
                               new Exam(orders[2], orders[3]);
                               System.out.println(Exam.examList.size());
                            }
                            else if(orders[1].equals("AddQuestion")){
                                ArrayList<String>questionOptions = new ArrayList<>();
                                for(int i=4;i<(orders.length-1);i++){
                                    questionOptions.add(orders[i]);
                                }
                                String questionPrompt = orders[3];
                                String questionAnswer = orders[orders.length-1];
                                Integer examNr = Integer.parseInt(orders[2]);   
                                Exam.examList.get(examNr-1).addQuestion(new Question(questionPrompt,questionOptions,questionAnswer));
                            }
                            break;
                        case("student"):
                            for (String replacestring : orders){
                                replacestring.replace("\n", "");
                            }
                            if(orders[1].equals("makeStudent")){
                                int studentNumberSaveFile = Integer.parseInt(orders[3]);
                                Student heinrich = new Student(orders[2], studentNumberSaveFile);
                                if(orders.length > 4){
                                    int counter = 0;
                                    while (counter < (orders.length-4)){
                                        Integer examNr = Integer.parseInt(orders[counter+4]);
                                        heinrich.behaaldeExamens.add(Exam.examList.get(examNr-1));
                                        counter++;
                                    }
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Error in method loadSaveFile");
            System.out.println(e);
        }
        System.out.println("Settings Loaded");
        System.out.println("=========================");
    }

    

    public static void exitSave() {
        File savefile = new File(Init.dir + "\\database.Wdf");
        File oldSavefile = new File(Init.dir + "\\oldDatabase.Wdf");
        cleanFile(savefile, true);
        //Write data to file here
        try{
            FileWriter saveWriter = new FileWriter(savefile,true);
            //Add the exams to the savefile
            int counter=1;
            for(Exam exams : Exam.examList){
                //System.out.println(exams.getName());//Debug
                saveWriter.append("exam"+":"+"newExam"+":"+exams.getName()+":"+exams.getCategory()+"\n");
                for(Question questions : exams.questionList){
                    saveWriter.append("exam"+":"+"AddQuestion"+":"+counter+":"+questions.questionPrompt+questions.contentsInString()+":"+questions.questionAnswer+"\n");
                }
                counter++;
                saveWriter.append("#\n");
            }
            
            for(Student student : Student.studentList){
                String passedExams = "";
                for(Exam studentPassedExam : student.behaaldeExamens){
                    int examCounter = 0;
                    for (Exam exam : Exam.examList){
                        if(exam.getName().equals(studentPassedExam.getName())){
                            passedExams += ":"+(examCounter+1);
                        }
                        examCounter++;
                    }
                    
                }
                saveWriter.append("student"+":"+"makeStudent"+":"+student.getName()+":"+student.getStudentNumber()+passedExams+"\n");
            }
            saveWriter.close();
            
            oldSavefile.delete();
            savefile.renameTo(oldSavefile);
            cleanFile(savefile, true);
            System.out.println("Data saved, exiting now");
        }
        catch(IOException e){
            System.out.println("Error in exitSave");
            System.out.println(e);
        }
        
    }

}
    

