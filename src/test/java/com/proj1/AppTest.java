package com.proj1;

import com.logic.App;
import com.logic.Exam;
import com.logic.Student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AppTest{

        TestScanner testScanner = new TestScanner();
        Student testStudent = new Student("Geerd", 21000321);
    
    public void testStudentGegevensAanwezig(){

    }

    /**Test of de studentnumber goed wordt teruggegeven als deze wel in de lijst staat */
    @Test
    public void testAskStudentNumber(){
        testScanner.setInt(21000321);
        assertEquals(21000321, App.askStudentNumber(testScanner));
    }
} 