package com.proj1;

public class YNQuestion extends Question
{
    boolean answerYN;

    public YNQuestion(Boolean answerYN, String text)
    {
        super(text);
        this.answerYN = answerYN;
    }

    public boolean getAYN ()
    {
        return answerYN;
    }

    @Override
    public boolean checkAnswer(String answer)
    {
           return true;
    }
}
