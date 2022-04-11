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
        }else if (examNummer == -1) {
                examNummer = 1;
        }else if (gehaald) {
                examNummer = 2;
        }else if (examNummer >= Exam.examList.size() || examNummer < -1) {
                examNummer = 3;
        }
        assertEquals(0, examNummer);
        assertEquals(false, gehaald);
        assertNotEquals(1, examNummer);
        assertNotEquals(2, examNummer);
        assertNotEquals(3, examNummer);
    }
}