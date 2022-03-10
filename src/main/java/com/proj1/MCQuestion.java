package com.proj1;

public class MCQuestion extends Question
{
    int answerMC;
    
    public MCQuestion(int answerMC, String text)
    {
        super(text);
        this.answerMC = answerMC;
    }
}
