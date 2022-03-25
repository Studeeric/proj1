package com.proj1;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.Test;

public class StudentTest {

    Student testStudent = new Student("Geerd", 21000321);
    
    //test of die de naam krijgt
    @Test
    public void getNameTest(){
        String testName = "Geerd";

        assertEquals(testName, testStudent.getName());

    }

    //test of het StudentNumber goed door komt
    @Test
    public void getStudentNumberTest(){
        int testStudentNumber = 21000321;
        int foutTestStudentNumber  = 21045678;

        assertEquals(testStudentNumber, testStudent.getStudentNumber());
        assertNotEquals(foutTestStudentNumber, testStudent.getStudentNumber());
        

    }
}
