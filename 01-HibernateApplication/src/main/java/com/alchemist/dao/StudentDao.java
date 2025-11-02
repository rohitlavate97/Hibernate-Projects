package com.alchemist.dao;

import com.alchemist.entity.Student;

public interface StudentDao {
	void saveStudent(Student student);
	Student loadStudent(int sid);
	Student updateStudentMarks(int sid, int marks);
	void deleteStudent(int sid);
}
