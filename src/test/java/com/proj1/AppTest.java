package com.proj1;

import com.logic.Exam;
import com.logic.Student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AppTest{
    Student testStudent = new Student("Geerd", 21000321);

    @Test
    public void testStudentExamStatus(){
        int studentNumber = 21000321;
        int i;
        for (i = 0; i < Student.studentList.size(); i++) {
            if (Student.studentList.get(i).getStudentNumber() == studentNumber) {
                studentNumber = i;
                break;
            }
        }
        assertEquals(0, i);
    }

    @Test
    public void testStudentExamStatus2(){
        int studentNumber = 0;
        int examNummer = 0;
        boolean gehaald = false;
        if (examNummer <= Exam.examList.size() && examNummer >= 0) {
            for (int i = 0; i < Student.studentList.get(studentNumber).behaaldeExamens.size(); i++) {
                if (Student.studentList.get(studentNumber).behaaldeExamens.get(i)
                        .equals(Exam.examList.get(examNummer))) {
                    gehaald = true;
                }
            }
        assertEquals(0, examNummer);
        } if (examNummer == -1) {
                examNummer = 1;
        } if (gehaald) {
                examNummer = 2;
        } if (examNummer >= Exam.examList.size() || examNummer < -1) {
                examNummer = 3;
        }
        assertNotEquals(1, examNummer);
        assertNotEquals(2, examNummer);
        assertEquals(3, examNummer);
        assertEquals(false, gehaald);
    }

    @Test
    public void testStudentExamPassed(){
            int studentNumber = 21000321;
            boolean studentFound = false;
            int counter = 0;
            for (int i = 0; i < Student.studentList.size(); i++) {
                if (Student.studentList.get(i).getStudentNumber() == studentNumber) {
                    studentNumber = i;
                    studentFound = true;
                    break;
                }
            } // Tot hier is al getest in de vorige methode vandaar geen assert statements!
            if (studentFound) {
                if (Student.studentList.get(studentNumber).behaaldeExamens.size() > 0) {
                    for (Exam exam : Student.studentList.get(studentNumber).behaaldeExamens) {
                        counter++;
                }
            }
        }
        assertEquals(0, counter);
        assertEquals(true, studentFound);
    }
} 