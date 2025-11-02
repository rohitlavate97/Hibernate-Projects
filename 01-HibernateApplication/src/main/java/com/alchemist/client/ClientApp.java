package com.alchemist.client;

import com.alchemist.entity.Student;
import com.alchemist.dao.*;
import com.alchemist.daoimpl.StudentDaoImpl;

public class ClientApp {
	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImpl();
		
		Student student = new Student();
		student.setSid(101);
		student.setSname("ROHIT");
		student.setGender("Male");
		student.setMarks(600);
		
		dao.saveStudent(student);
	}

}
