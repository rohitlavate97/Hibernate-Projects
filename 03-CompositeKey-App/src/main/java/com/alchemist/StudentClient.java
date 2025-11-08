package com.alchemist;

import com.alchemist.dao.*;
import com.alchemist.entity.StudentCompositeKey;
import com.alchemist.entity.StudentEntity;

/**
 * Hello world!
 */
public class StudentClient {
    public static void main(String[] args) {
    	StudentDao dao = new StudentDaoImpl();
    	
    	StudentCompositeKey key = new StudentCompositeKey();
    	key.setRollNumber(101);
    	key.setSection("A");
    	
        StudentEntity student = new StudentEntity();
        student.setCompositeKey(key);
        student.setStudentName("Rohit");
        student.setMarks("500");
        
        dao.saveStudent(student);
    }
}
