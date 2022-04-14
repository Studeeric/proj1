package com.logic;import java.io.File;

public abstract class Init {

    private Init(){} //private constructor means no objects can be made of this class

    public static String dir = System.getProperty("user.dir")+"\\database\\";

    public static void init(boolean debugMode,IScanner scanner) {
        try{
            File savefile = new File(Init.dir + "\\oldDatabase.Wdf");
            if(!savefile.exists()){
                savefile.createNewFile();
            }
            SaveManager.loadSaveFile(dir+"oldDatabase.Wdf");
            if(debugMode){
                Debug.DebugSet(scanner);
            }
        }
        catch(Exception e){
            System.out.println("Error in Init");
            System.out.println(e);
        }
    }
}
