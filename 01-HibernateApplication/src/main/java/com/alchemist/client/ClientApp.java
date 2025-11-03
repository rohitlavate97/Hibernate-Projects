package com.alchemist.client;

import com.alchemist.entity.Student;
import com.alchemist.dao.*;
import com.alchemist.daoimpl.StudentDaoImpl;

public class ClientApp {
	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImpl();
		
		/*
		 * Student student = new Student(); student.setSid(102);
		 * student.setSname("PRAMOD"); student.setGender("Male"); student.setMarks(700);
		 * 
		 * dao.saveStudent(student);
		 */
		 
		/*Student student = dao.loadStudent(1);*/
		/*
		 * Student student = dao.updateStudentMarks(1, 720);
		 * System.out.println(student);
		 * 
		 * dao.deleteStudent(2);
		 */
		
		dao.levelOneCacheTest();
	}

}
