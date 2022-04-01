package com.proj1;import java.util.ArrayList;

public class Question 
{
    ArrayList<String> questionContents = new ArrayList<>(); //Because the savemanager makes the questions, index[0] is always the question & index[index.length-1] is always the answer

    public Question (ArrayList<String> contents){
        this.questionContents = contents;
    }

    public ArrayList<String> askQuestion(){ //needs rewriting
        return this.questionContents;
    }

    public boolean checkAnswer(String input){
        if (input.equals(questionContents.get(questionContents.size()-1))| input.equals(questionContents.get(questionContents.size()-1).toLowerCase())){
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