package com.proj1; 

import com.logic.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    private ArrayList<String> questOptions;
    private Question testQuestion;

    @BeforeEach
    public void init(){
        questOptions = new ArrayList<>();
        testQuestion = new Question("TestPrompt", questOptions, "TestAnswer");
    }

    @AfterEach
    public void clear(){
        testQuestion.questionContents.clear();
    }

    //testen of de opties over een komen
    @Test
    public void testAskQuestion(){
        testQuestion.questionContents.add("grumbel");
        assertEquals("grumbel", testQuestion.askQuestion().get(0));      
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
    }  
}
