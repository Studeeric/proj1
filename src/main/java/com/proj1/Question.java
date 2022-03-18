package com.proj1;

public class Question 
{
    String text;
    String answer;

    public Question (String text, String answer){
        this.text = text;
        this.answer = answer;
    }

    public String askQuestion(){
        return text;
    }

    public boolean checkAnswer(String input){
        if (input.equals(answer)){
            return true;
        }
           return false;
    }
}