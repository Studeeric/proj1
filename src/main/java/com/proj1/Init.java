package com.proj1;import java.io.File;

public abstract class Init {
    public static String dir = System.getProperty("user.dir")+"\\database\\";

    public static void init(boolean debugMode) {
        try{
            File savefile = new File(Init.dir + "\\oldDatabase.Wdf");
            if(!savefile.exists()){
                savefile.createNewFile();
            }
            SaveManager.loadSaveFile(dir+"oldDatabase.Wdf",debugMode);
        }
        catch(Exception e){
            System.out.println("Error in Init");
            System.out.println(e);
        }
    }
    

    /*
    private static void legacyInit(boolean usethis){
        if(usethis){
            Exam rekenen = new Exam("Rekenen voor beginners", "Rekenen");
            rekenen.addQuestion(new Question("Wat is 2 + 2?\n A) 1\n B) 2\n C) 3\n D) 4\n", "D"));
            rekenen.addQuestion(new Question("Wat is 2 - 2?\n A) 0\n B) 1\n C) 2\n D) 3\n", "A"));
            rekenen.addQuestion(new Question("Wat is 1 + 1?\n A) 1\n B) 2\n C) 3\n D) 4\n", "B"));
            rekenen.addQuestion(new Question("Wat is 3 x 2?\n A) 4\n B) 5\n C) 6\n D) 8\n", "C"));
            rekenen.addQuestion(new Question("Wat is 610 x 410 / 5104?\n A) 2\n B) 55.6\n C) 50.2\n D) 49.0\n", "D"));

            Exam tekenen = new Exam("Kleuren voor beginners", "Tekenen");
            tekenen.addQuestion(new Question("Wat krijg je als je blauw en geel mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "A"));
            tekenen.addQuestion(new Question("Wat krijg je als je rood en wit mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "B"));
            tekenen.addQuestion(new Question("Wat krijg je als je blauw en rood mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "C"));
            tekenen.addQuestion(new Question("Wat krijg je als je rood en geel mixt?\n A) Groen\n B) Roze\n C) Paars\n D) Oranje\n", "D"));

            new Student("Eric", 21146632);
            new Student("Lucas", 21093830);
            new Student("Wessel", 21046220);
            new Student("Burton",21035407);
            new Student("Wouter", 21076367);
        }
    }
    */ //I ain't fixing this shit
    
}
