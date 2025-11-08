package com.alchemist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentCompositeKey implements Serializable{
	
	@Column(name = "ROLLNO")
	private Integer rollNumber;
	@Column(name = "SECTION")
	private String section;
	
	public Integer getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}

}
