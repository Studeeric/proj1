package com.logic;import java.util.ArrayList;

public class Question {
    /**Contains the possible options in a question */
    public ArrayList<String> questionContents = new ArrayList<>();
    /**Contains the Prompt or the actual question */
    public String questionPrompt;
    /**Contains the answer to a question */
    public String questionAnswer;

    public Question (String prompt,ArrayList<String> contents,String answer){
        this.questionPrompt = prompt;
        this.questionContents = contents;
        this.questionAnswer = answer;
    }

    public ArrayList<String> askQuestion(){
        return this.questionContents;
    }

    public boolean checkAnswer(String input){
        if (input.equals(questionAnswer)){
            return true;
        }
           return false;
    }

    public String contentsInString(){
        String contents = "";
        for(String i : questionContents){
            contents +=":"+i;
        }
        return contents;
    }
}
