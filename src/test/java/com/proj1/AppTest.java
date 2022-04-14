package com.proj1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.logic.App;
import com.logic.Student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
  
  private TestScanner testScanner;
  private RepeatingTestScanner testScanner2;

    @BeforeEach
    public void init(){
        testScanner = new TestScanner();
        testScanner2 = new RepeatingTestScanner();
    }

    @AfterEach
    public void exit(){
        testScanner2.clear();
    }

    /** Test alle opties bij studentgegevensafwezig en kijkt of de juiste respons word gegeven */
    @Test
    public void testStudentGegevensAfwezig(){
        testScanner.setInt(1);
        assertTrue(App.studentGegevensAfwezig(testScanner));

        testScanner.setInt(2);
        assertTrue(App.studentGegevensAfwezig(testScanner));

        testScanner.setInt(0);
        assertFalse(App.studentGegevensAfwezig(testScanner));

        testScanner2.intlist.add(10);
        testScanner2.intlist.add(1);
        testScanner2.sendlist.add("\n");
        assertTrue(App.studentGegevensAfwezig(testScanner2));
    }

    /**Test of de studentnumber goed wordt teruggegeven als deze wel in de lijst staat */
    @Test
    public void testAskStudentNumber(){
        new Student("name", 21000321);
        //als de studentnumber wel in de lijst zit
        testScanner.setInt(21000321);
        assertEquals(21000321, App.askStudentNumber(testScanner));

        //als de studentnumber niet in de lijst zit
        testScanner.setInt(0);
        assertEquals(-1, App.askStudentNumber(testScanner));
    }
} 