package com.proj1; import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertNotEquals; import org.junit.jupiter.api.Test;
//Of junit5 (e.g. org.junit.jupiter) of junit4 (e.g. org.junit.Test)
public class ExamTest {

    Exam TestExam = new Exam("OPT1", "HBO-ICT");

    //test of de naam wordt opgevraagd
    @Test
    public void getNameTest(){
        String TestName = "OPT1";
        String foutTestName = "Biologie";
        
        String resultName = TestExam.getName();
        assertEquals(TestName, resultName);
        assertNotEquals(foutTestName, resultName);
    }

    //test of de category wordt opgevraagd
    @Test
    public void getCategoryTest(){
        String TestCategory = "HBO-ICT";
        String foutTestCategory = "Beta";

        String resultCategory = TestExam.getCategory();
        assertEquals(TestCategory, resultCategory);
        assertNotEquals(foutTestCategory, resultCategory);
    }
    
}
