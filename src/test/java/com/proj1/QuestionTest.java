package com.proj1; 

import com.logic.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QuestionTest {
    ArrayList<String> questOptions = new ArrayList<>();
    Question testQuestion = new Question("TestPrompt", questOptions, "TestAnswer");

    //testen of de opties over een komen
    @Test
    public void testAskQuestion(){
        testQuestion.questionContents.add("grumbel");
        assertEquals("grumbel", testQuestion.askQuestion().get(0));   
        testQuestion.questionContents.clear();    
    }

    @Test
    public void testCheckAnswer(){
        testQuestion.questionAnswer = "1";
        assertTrue(testQuestion.checkAnswer("1"));
        assertFalse(testQuestion.checkAnswer("2"));

    }

    @Test
    public void testContentsInString() {
        testQuestion.questionContents.add("testText2");
        testQuestion.questionContents.add("Banaan");
        String contents = testQuestion.contentsInString();
        assertEquals(":testText2:Banaan", contents);
        testQuestion.questionContents.clear();
    }
   
}

