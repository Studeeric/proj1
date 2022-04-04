<<<<<<< HEAD
package com.proj1;



import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.Test;
=======
package com.proj1; import static org.junit.jupiter.api.Assertions.assertEquals; import static org.junit.jupiter.api.Assertions.assertNotEquals; import org.junit.jupiter.api.Test;
>>>>>>> 0dd172e8126db9bf99efc35b9963822617428675

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
    
    // Deze test is er om een methode aan te kunnen roepen voor het aanmaken van een nieuwe student
    @Test
    public void medewerkerAddTest(){
        String naam = "Minte Eskes";
        String naamTest = "Minte Eskes";
        int studentNummer = 240;
        Student student = new Student(naam, studentNummer);

       assertEquals(naamTest, student.getName());
}

}