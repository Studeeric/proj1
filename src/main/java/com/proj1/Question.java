package com.proj1;import java.util.ArrayList;

public class Question 
{
    public ArrayList<String> questionContents = new ArrayList<>(); //Because the savemanager makes the questions, index[0] is always the question & index[index.length-1] is always the answer
    public String questionPrompt;
    public String questionAnswer;

    public Question (String prompt,ArrayList<String> contents,String answer){
        this.questionContents = contents;
        this.questionPrompt = prompt;
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
