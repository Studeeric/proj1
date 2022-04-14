package com.proj1;
import com.logic.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class exManagerTest {
    RepeatingTestScanner Rescanner = new RepeatingTestScanner();

    @Test
    public void testNewExam(){
        String examName = "Koken Met idioten";
        Rescanner.sendlist.add(examName);
        Rescanner.sendlist.add("Kookcursus");
        Rescanner.sendlist.add("0");
        //AddQuestions
        ExamManager.exNewExam(Rescanner);
        Exam examen = Exam.examList.get(0);
        assertEquals(1, Exam.examList.size());
        assertEquals(examen.getName(), examName);
        Rescanner.clear();
        Exam.examList.clear();
    }

    @Test
    public void testAddQuestion() {
        String questionPrompt = "Hoe Maak je mushroom Stew?";
        Rescanner.sendlist.add(questionPrompt);
        Rescanner.sendlist.add("Niet");
        Rescanner.sendlist.add("Mushroom Cow + bowl");
        Rescanner.sendlist.add("0");
        Rescanner.sendlist.add("1");
        Rescanner.sendlist.add("0");

        //Formatting to remove the option inputs from the sendlist
        String expected = "";
        String actual = "";
        for(String line : Rescanner.sendlist)
            expected +=line.replace(" ", "").replace("0", "");
        for(String line : ExamManager.exGetQuestCont(Rescanner))
            actual += line.replace(" ", "");
        assertEquals(expected, actual);
        Rescanner.clear();
    }
}
