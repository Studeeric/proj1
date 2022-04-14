package com.proj1;

import com.logic.App;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
  
  private TestScanner testScanner;
  
    @BeforeEach
    public void init(){
        testScanner = new TestScanner();
    }

    /** Test alle opties bij studentgegevensafwezig en kijkt of de juiste respons word gegeven */
    @Test
    public void testStudentGegevensAfwezig(){
        testScanner.setInt(1);
        assertEquals(true, App.studentGegevensAfwezig(testScanner));

        testScanner.setInt(2);
        assertEquals(true, App.studentGegevensAfwezig(testScanner));

        testScanner.setInt(0);
        assertEquals(false, App.studentGegevensAfwezig(testScanner));

        testScanner.setInt(10);
        assertEquals(false, App.studentGegevensAfwezig(testScanner));
    }

    /**Test of de studentnumber goed wordt teruggegeven als deze wel in de lijst staat */
    @Test
    public void testAskStudentNumber(){
        //als de studentnumber wel in de lijst zit
        testScanner.setInt(21000321);
        assertEquals(21000321, App.askStudentNumber(testScanner));

        //als de studentnumber niet in de lijst zit
        testScanner.setInt(0);
        assertEquals(-1, App.askStudentNumber(testScanner));
    }
} 