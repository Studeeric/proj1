package com.proj1; import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.logic.Student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTest {

    private Student testStudent;
    private TestScanner testScanner;
    private RepeatingTestScanner rescanner;
    
    @BeforeEach
    public void init(){
        testStudent = new Student("Geerd", 21000321);
        testScanner = new TestScanner();
        rescanner = new RepeatingTestScanner();
    }

    @AfterEach
    public void clear(){
        rescanner.clear();
    }
  
    //test of die de naam krijgt
    @Test
    public void testNewStudent(){
        // Test of de naam goed doorkomt
        String testName = "Geerd";
        String foutTestName = "Lucas";
        assertEquals(testName, testStudent.getName());
        assertNotEquals(foutTestName, testStudent.getStudentNumber());

        // Test of de studentnumber correct doorkomt
        int testStudentNumber = 21000321;
        int foutTestStudentNumber = 21045678;
        assertEquals(testStudentNumber, testStudent.getStudentNumber());
        assertNotEquals(foutTestStudentNumber, testStudent.getStudentNumber());
    }

    /**Checkt of studentnumber goed doorkomt */
    @Test
    public void testNewStudent2(){
        testScanner.setInt(21000321);
        testScanner.setString("2100321");
        int testStudentNumber = 21000321;
        Student.newStudent(testScanner);
        assertEquals(testStudentNumber, testStudent.getStudentNumber());
    }

    @Test
    public void testNewStudent3(){
        rescanner.sendlist.add("Geerd");
        
    }

    //test of de student verwijderd word
    @Test
    public void testDeleteStudent() {
        String juist = "gelukt";
        String test = "nietGelukt";
        String naam = "Geerd";
        int nummer = 21000321;
        for (int e = 0; e < Student.studentList.size(); e++){
            if (testStudent.getName() == naam && testStudent.getStudentNumber() == nummer){
                Student.studentList.remove(testStudent);
                  test = "gelukt";
            }
        }
        assertEquals(juist, test);
    }
    
    // Deze test is er om een methode aan te kunnen roepen voor het aanmaken van een nieuwe student
    @Test
    public void testStudentAdd(){
        String naam = "Minte Eskes";
        String naamTest = "Minte Eskes";
        int studentNummer = 240;
        Student student = new Student(naam, studentNummer);

       assertEquals(naamTest, student.getName());
    }   
}