package com.logic; import java.util.ArrayList;
import com.ui.UI;
import com.ui.exManagerUI;

/*
=======Class Explanation=======
This class manages creating, deleting & editing exams and the questions in them.
Thanks for coming to my TED talk.
*/
//TODO Nog steeds buggy bij exAddQuestion
// question prompt is printed when asked for the right option in exGetQuestContent
// Fixed the question prompt thingy but the right answer selection doesn't work right and its 0:23 AM

/**
 * This class manages creating, deleting & editing exams and the questions in them.
 */
abstract public class ExamManager {

    private ExamManager(){} //private constructor means no objects can be made of this class

    public static void exManagerMenu(IScanner scanner) {
        exManagerLoop: while (true) {
            exManagerUI.printExManagerMenu();
            String userChoiceExManager = scanner.nextLine();
            switch(userChoiceExManager){
                case("1"):
                    exNewExam(scanner);
                    break;
                case("2"):
                    exRemoveExam(scanner, exChooseExamIndex(scanner,false));
                    break;
                case("3"):
                    exEditExam(scanner);
                    break;
                case("0"):
                    UI.clearScreen();
                    exManagerUI.printExReturnMainMenu(false);
                    Debug.wait(1,true);
                    break exManagerLoop;
                default:
                    exManagerUI.printExReturnMainMenu(true);
                    Debug.wait(2,true);
                    break;
            }
        }
    }

    //Action methods
    public static void exNewExam(IScanner scanner) {
        exManagerUI.printExExamInput(true);
        String newExName = scanner.nextLine();
        while(newExName.equals("")){
            exManagerUI.printExExamInputError(true);
            newExName = scanner.nextLine();
        }
        exManagerUI.printExExamInput(false);
        String newExCat = scanner.nextLine();
        while(newExCat.equals("")){
            exManagerUI.printExExamInputError(false);
            newExCat = scanner.nextLine();
        }
        Exam exManagerCreated = new Exam(newExName, newExCat);
        exManagerUI.printExAddOptions(true);
        if(scanner.nextLine().equals("1")){
            exAddQuestion(exManagerCreated,scanner);
        }
        exManagerUI.printExAddOptions(false);
        Debug.wait(2,true);
    }

    public static void exRemoveExam(IScanner scanner,int exToBeRemoved) {
        UI.clearScreen();
        exManagerUI.printExRemoveMenu(Exam.examList.get(exToBeRemoved).getName(),Exam.examList.get(exToBeRemoved).getCategory());
        exRemoveLoop: while (true){
            switch(scanner.nextLine()){
                case("1"):
                    Exam.examList.remove(exToBeRemoved);
                    exManagerUI.printExRemoveReact(true);
                    break exRemoveLoop;
                case("0"):
                    exManagerUI.printExRemoveReact(true);
                    break exRemoveLoop;
                default:
                exManagerUI.printExRemoveDefaultError();
                    break;
            }
        }   
    }

    public static void exEditExam(IScanner scanner) {
        UI.clearScreen();
        exEditMainLoop: while(true){
            exManagerUI.printExEditQuestionEditQuestion(true);
            int exIndex = exChooseExamIndex(scanner,true);
            if(exIndex != -1){
                Exam exActualExam = Exam.examList.get(exIndex);
                exEditSubLoop: while (true){
                    exManagerUI.printExEditMainMenu();
                    switch(scanner.nextLine()){
                        case("1"):
                            exAddQuestion(exActualExam, scanner);
                            break;
                        case("2"):
                            exRemoveQuestion(exActualExam, scanner);
                            break;
                        case("3"):
                            exEditQuestion(exActualExam,scanner);
                            break;
                        case("0"):
                            break exEditSubLoop;
                            
                        default:
                            break;
                    }
                }
            }
            else{break exEditMainLoop;}
        } 
    }
    //TODO Legacy code. 
    /*
    public static void exEditQuestion(Exam exActualExam,IScanner scanner) {
        exManagerUI.printExEditQuestionEditQuestion(true);
        for(int i = 0; i< exActualExam.questionList.size();i++){
            exManagerUI.printExEditQuestionList(i, exActualExam.questionList.get(i).questionPrompt);
        }
        exManagerUI.printExEditQuestionList();

        int exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
        if(exUserEditChoice != -1){
            Question exChosenQuest = exActualExam.questionList.get(exUserEditChoice);
            UI.clearScreen();
            
            exPrintQuestArray(exChosenQuest.questionContents, true);
            exManagerUI.printExEditQuestionEditQuestion(true);
            exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
            UI.clearScreen();
            
            exManagerUI.printExEditQuestionEditMenu(exChosenQuest.questionContents.get(exUserEditChoice));
            exChosenQuest.questionContents.set(exUserEditChoice, scanner.nextLine());
            exManagerUI.printExEditQuestionEditConfirm();
            App.pauseMenu(scanner);
        }

    }
    */
    public static void exEditQuestion(Exam exActualExam,IScanner scanner) {
        exManagerUI.printExEditQuestionEditQuestion(true);
        for(int i = 0; i< exActualExam.questionList.size();i++){
            exManagerUI.printExEditQuestionList(i, exActualExam.questionList.get(i).questionPrompt);
        }
        exManagerUI.printExEditQuestionList();
        int exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
        if(exUserEditChoice != -1){
            Question exChosenQuest = exActualExam.questionList.get(exUserEditChoice);
            ArrayList<String> exChosenQuestList = new ArrayList<>(exConvertToList(exChosenQuest));
            UI.clearScreen();
            exManagerUI.exPrintQuestArray(exChosenQuestList, true);
            exManagerUI.printExEditQuestionEditQuestion(true);
            exUserEditChoice = Integer.parseInt(scanner.nextLine())-1;
            UI.clearScreen();
            exManagerUI.printExEditQuestionEditMenu(exChosenQuestList.get(exUserEditChoice));
            exChosenQuestList.set(exUserEditChoice, scanner.nextLine());
            exNewFormatQuestion(exChosenQuest, exChosenQuestList);
            exManagerUI.printExEditQuestionEditConfirm();
        }
    }

    //Support methods
    public static void exAddQuestion(Exam exam, IScanner scanner) {
        UI.clearScreen();
        exAddQuestLoop1: while(true){
            UI.clearScreen();
            exManagerUI.printExAddQMenu(exam.getQuestionList().size());
            switch (scanner.nextLine()) {
                case ("1"):
                    exam.addQuestion(exFormatQuestion(exGetQuestCont(scanner)));
                    break;
                case("2"):
                    UI.clearScreen();
                    int counter = 1;
                    for(Question question : exam.questionList){
                        exManagerUI.printExAddQLoop(true, null,counter);
                        exManagerUI.printExAddQuestVars(question.questionPrompt,false);
                        for(String content : question.questionContents){
                            exManagerUI.printExAddQLoop(false, content,0);
                        }
                        exManagerUI.printExAddQuestVars(question.questionAnswer,true);
                        counter++;
                    }
                    App.pauseMenu(scanner);
                    break;
                case ("0"):
                    break exAddQuestLoop1;
                default:
                    break;
            }
        }
    }

    public static void exRemoveQuestion(Exam exActualExam, IScanner scanner) {
        UI.clearScreen();
        exManagerUI.prinExRemoveQuestAsk(0,null, false);
        for(int i = 0; i< exActualExam.questionList.size();i++){
            exManagerUI.prinExRemoveQuestAsk(i,exActualExam.questionList.get(i).questionPrompt, true);
        }
        exManagerUI.printExAddQuestVars("",false);
        int exToBeRemoved = Integer.parseInt(scanner.nextLine());
        UI.clearScreen();
        exManagerUI.printExRemoveQuestConfirm(exActualExam.questionList.get(exToBeRemoved).questionPrompt);
        exRemoveQuestLoop: while (true){
            switch(scanner.nextLine()){
                case("1"):
                    exActualExam.questionList.remove(exToBeRemoved);
                    exManagerUI.printExRemoveQuestReturn(true);
                    break exRemoveQuestLoop;
                case("n"):
                case("N"):
                case("no"):
                case("No"):
                case("nee"):
                case("Nee"):
                    exManagerUI.printExRemoveQuestReturn(false);
                    break exRemoveQuestLoop;
                default:
                    exManagerUI.printExRemoveDefaultError();
                    break;
            }
        }
    }

    public static int exChooseExamIndex(IScanner scanner, boolean exit) {
        Exam.printAllExams(scanner);
        if(exit){
            exManagerUI.printExEditQuestionList();
        }
        Integer examNr;
        while (true){
            String exChooseExChoice = scanner.nextLine();
            try{
                examNr = Integer.parseInt(exChooseExChoice);
                break;
            }
            catch(Exception e){
                exManagerUI.printExReturnMainMenu(false);
            }
        }
        return examNr-1;
    }

    public static ArrayList<String> exGetQuestCont(IScanner scanner) {
        ArrayList<String> exQuestContents = new ArrayList<>();
        exManagerUI.printExGetQuestCt(1);
        String questPrompt = scanner.nextLine();
        while(questPrompt.equals("")){
            exManagerUI.printExExamInputError(false);
            questPrompt = scanner.nextLine();
        }
        exQuestContents.add(questPrompt);
        exGetQuestLoop: while (true){
            exManagerUI.printExGetQuestCt(2);
            String exUserChoice = scanner.nextLine();
            switch(exUserChoice){
                case("0"):
                    break exGetQuestLoop;
                default:
                    exQuestContents.add(" "+exUserChoice);
                    break;
            }
        }
        UI.clearScreen();
        exManagerUI.printExGetQuestCt(3);
        exManagerUI.exPrintQuestArray(exQuestContents,true);
        exQuestContents.add(scanner.nextLine());
        return exQuestContents;
    }

    public static Question exFormatQuestion(ArrayList<String> contents) {
        ArrayList<String> questionOptions = new ArrayList<>();
        for(int i =1;i<contents.size()-1;i++){
            questionOptions.add(contents.get(i));
        }
        return new Question(contents.get(0), questionOptions, contents.get(contents.size()-1));
    }

    public static Question exNewFormatQuestion(Question quest, ArrayList<String> contents){
        ArrayList<String> questionOptions = new ArrayList<>();
        String prompt = contents.get(0);
        String answer = contents.get(contents.size()-1);
        for(int i =1;i<contents.size()-1;i++){
            questionOptions.add(contents.get(i));
        }
        quest.questionContents = questionOptions;
        quest.questionPrompt = prompt;
        quest.questionAnswer = answer;
        return quest;
    }

    public static ArrayList<String> exConvertToList(Question quest) {
        ArrayList<String> contents = new ArrayList<>();
        contents.add(quest.questionPrompt);
        for(String str : quest.questionContents){
            contents.add(str);
        }
        contents.add(quest.questionAnswer);
        return contents;
    }
}
