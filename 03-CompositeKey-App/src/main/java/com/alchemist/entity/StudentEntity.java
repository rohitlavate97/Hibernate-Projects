package com.alchemist.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_DTLS")
public class StudentEntity {
	@EmbeddedId
	private StudentCompositeKey compositeKey;
	@Column(name = "SNAME")
	private String studentName;
	@Column(name = "MARKS")
	private String marks;
	public StudentCompositeKey getCompositeKey() {
		return compositeKey;
	}
	public void setCompositeKey(StudentCompositeKey compositeKey) {
		this.compositeKey = compositeKey;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	
	
}
