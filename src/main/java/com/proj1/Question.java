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
        return this.text;
    }

    public boolean checkAnswer(String input){
        if (input.equals(answer) | input.equals(answer.toLowerCase())){
            return true;
        }
           return false;
    }
}