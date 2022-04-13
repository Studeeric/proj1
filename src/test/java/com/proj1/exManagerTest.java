package com.proj1;
import com.logic.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class exManagerTest {
    RepeatingTestScanner Rescanner = new RepeatingTestScanner();
    @Test
    public void testNewExam(){
        String examName = "Koken Met idiooten";
        Rescanner.sendlist.add(examName);
        Rescanner.sendlist.add("Kookcursus");
        Rescanner.sendlist.add("0");
        ExamManager.exNewExam(Rescanner);
        assertEquals(1, Exam.examList.size());
        assertEquals(Exam.examList.get(0).getName(), examName);

    }
    
}
