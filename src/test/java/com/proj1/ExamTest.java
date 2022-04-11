package com.proj1; import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import com.logic.Exam;
import com.logic.Question;
import com.logic.Student;

import org.junit.jupiter.api.Test;

//Of junit5 (e.g. org.junit.jupiter) of junit4 (e.g. org.junit.Test)
public class ExamTest {
    static TestScanner testScanner = new TestScanner();
    static Exam testExam = new Exam("OPT1", "HBO-ICT");
    static Student testStudent = new Student("Pietje", 21146633);
    static Student testStudent2 = new Student("Klaasje", 21146634);
    static ArrayList<String> questionStringList = new ArrayList<>();
    static Question question = new Question("prompt", questionStringList, "1");
    static Question question2 = new Question("prompt", questionStringList, "1");


    //test of de naam wordt opgevraagd
    @Test
    public void testGetName(){
        String testName = "OPT1";
        String foutTestName = "Biologie";
        
        String resultName = testExam.getName();
        assertEquals(testName, resultName);
        assertNotEquals(foutTestName, resultName);
    }

    //test of de category wordt opgevraagd
    @Test
    public void testGetCategory(){
        String testCategory = "HBO-ICT";
        String foutTestCategory = "Beta";

        String resultCategory = testExam.getCategory();
        assertEquals(testCategory, resultCategory);
        assertNotEquals(foutTestCategory, resultCategory);
    }

    /*
    Deze test test of een examen goed wordt toegevoegd bij een student. 
    */
    @Test
    public void testAddExam(){
        testExam.examResult(testStudent, 0, true);
        testExam.examResult(testStudent2, 0, false);
        assertEquals(testExam, testStudent.behaaldeExamens.get(0));
        assertTrue(testStudent2.behaaldeExamens.isEmpty());
    }

    @Test
    public void testGetExam(){
        assertEquals(testExam, Exam.getExam(0));
        Exam.examList.remove(0);
        Exam.printAllExams(testScanner);
        assertTrue(Exam.examList.isEmpty());
    }
    
    @Test
    public void testAddQuestion(){
        testExam.addQuestion(question);
        assertEquals(question, testExam.questionList.get(0));;
    }

    @Test
    public void testGetQuestionlist(){
        assertEquals(testExam.questionList, testExam.getQuestionList());
    }

    @Test
    public void testStartExam(){
        questionStringList.add("random");
        testExam.addQuestion(question);
        testExam.addQuestion(question2);
        testScanner.setInt(1);
        testScanner.setString("1");
        testExam.startExam(testStudent, testScanner);
        testScanner.setInt(2);
        testScanner.setString("2");
        testExam.startExam(testStudent2, testScanner);
        assertEquals(testStudent.behaaldeExamens.get(0), testExam);
        assertTrue(testStudent2.behaaldeExamens.isEmpty());
    }
}
