package com.proj1;
import com.logic.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class exManagerTest {
    RepeatingTestScanner rescanner;

    @BeforeEach
    public void init(){
        rescanner = new RepeatingTestScanner();
    }

    @AfterEach
    public void clear(){
        rescanner.clear();
        Exam.examList.clear();
    }

    @Test
    public void testNewExam(){
        String examName = "Koken Met idioten";
        rescanner.sendlist.add(examName);
        rescanner.sendlist.add("Kookcursus");
        rescanner.sendlist.add("0");
        //AddQuestions
        ExamManager.exNewExam(rescanner);
        Exam examen = Exam.examList.get(0);
        assertEquals(1, Exam.examList.size());
        assertEquals(examen.getName(), examName);
        
    }

    @Test
    public void testAddQuestion() {
        String questionPrompt = "Hoe Maak je mushroom Stew?";
        rescanner.sendlist.add(questionPrompt);
        rescanner.sendlist.add("Niet");
        rescanner.sendlist.add("Mushroom Cow + bowl");
        rescanner.sendlist.add("0");
        rescanner.sendlist.add("1");
        rescanner.sendlist.add("0");

        //Formatting to remove the option inputs from the sendlist
        String expected = "";
        String actual = "";
        for(String line : rescanner.sendlist)
            expected +=line.replace(" ", "").replace("0", "");
        for(String line : ExamManager.exGetQuestCont(rescanner))
            actual += line.replace(" ", "");
        assertEquals(expected, actual);
    }
}
