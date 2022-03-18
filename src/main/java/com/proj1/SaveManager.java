package com.proj1; import java.util.Scanner; import java.io.IOException; import java.io.File; import java.io.FileWriter; import java.util.ArrayList;

public class SaveManager {

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
    
    public static void appendFile(Scanner gustav,String fileName, String writable){
        /*
        System.out.println("Enter text:");
        String writable = gustav.nextLine();
        */

        ArrayList<String> fileContents = new ArrayList<String>(readFile(fileName,true));

        //Append the given data to the file
        try{
            fileContents.add(writable);
            if(cleanFile(fileName)){
                FileWriter saveWriterEditAppend = new FileWriter(fileName, true);
                for (String entry : fileContents){
                    saveWriterEditAppend.write(entry + "\n");
                }
                saveWriterEditAppend.close();
            }
        }
        catch(Exception e){
            //Debug remove in production
            System.out.println("Error in method appendFile!");
            System.out.println(e);
        }
        System.out.println("=========================");
    }

    public static void editFile(Scanner charles,String fileName,boolean debugEditFile) {
        ArrayList<String> fileContents = new ArrayList<String>(readFile(fileName,!debugEditFile));

        //Select and change the line.
        if (debugEditFile){
            System.out.println("Which line to edit?");
            int userEditLineChoice = charles.nextInt();
            charles.nextLine();
            System.out.println("line " + userEditLineChoice + " selected. \nEdit Line: ");
            String userEditLineContent = charles.nextLine();
            fileContents.set(userEditLineChoice-1, userEditLineContent);
        }
        

        //Write the changes to the file
        try{
            if(cleanFile(fileName)){
                FileWriter saveWriterEditAppend = new FileWriter(fileName, true);
                for (String entry : fileContents){
                    saveWriterEditAppend.write(entry + "\n");
                }
                saveWriterEditAppend.close();
                System.out.println("Edit succesfull"); //Debug
            }
        }
        catch(Exception e){
            //Debug remove in production
            System.out.println("A error has occured in method editFile");
            System.out.println(e);
        }
        System.out.println("=========================");
    }

    public static void removeFromFile(Scanner augustus, String fileName) {
        
        ArrayList<String> fileContents = new ArrayList<String>(readFile(fileName,true));

        //Select and remove line
        System.out.println("Which line to remove?");
        int counter = 1;
        for (String entry : fileContents){
            System.out.println(counter + ") " + entry);
            counter++;
        }
        int userRemoveLineChoice = augustus.nextInt();
        augustus.nextLine();
        System.out.println("line " + userRemoveLineChoice + " selected for removal");
        fileContents.remove(userRemoveLineChoice-1);

        try{
            if(cleanFile(fileName)){
                FileWriter saveWriterEditAppend = new FileWriter(fileName, true);
                for (String entry : fileContents){
                    saveWriterEditAppend.write(entry + "\n");
                }
                saveWriterEditAppend.close();
                System.out.println("Line Removed"); //Debug
                System.out.println("=========================");
            }
        }
        catch(Exception e){
            //Debug remove in production
            System.out.println("Oh no a Error has occured in method removeFromFile()");
            System.out.println(e);
        }
        
    }

    public static boolean cleanFile(String fileName) {
        File savefile = new File(fileName);
        try{
            if(savefile.delete()){
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

    public static void loadSaveFile(String fileName){
        ArrayList<String> fileContents = new ArrayList<String>(readFile(fileName,true));
        try{
            for (String entries : fileContents){
                entries = entries.replace("\n", "");
                String[] orders = entries.split(":");
                    if(orders[0].equals("1")){
                    }
            }
        }
        catch(Exception e){
            System.out.println("Error in method loadSaveFile");
        }
        System.out.println("Settings Loaded");
        System.out.println("=========================");
    }
}
    

