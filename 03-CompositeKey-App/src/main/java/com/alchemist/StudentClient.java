package com.alchemist;

import com.alchemist.dao.*;
import com.alchemist.entity.StudentCompositeKey;
import com.alchemist.entity.StudentEntity;

public class StudentClient {
    public static void main(String[] args) {
    	StudentDao dao = new StudentDaoImpl();
    	
		/*
		 * StudentCompositeKey key = new StudentCompositeKey(); key.setRollNumber(102);
		 * key.setSection("B");
		 * 
		 * StudentEntity student = new StudentEntity(); student.setCompositeKey(key);
		 * student.setStudentName("Pavan"); student.setMarks("450");
		 * 
		 * dao.saveStudent(student);
		 */
    	StudentCompositeKey key = new StudentCompositeKey();
    	key.setRollNumber(101);
    	key.setSection("B");
    	StudentEntity student = dao.fetchStudent(key);
    	System.out.println(student);
    }
}
