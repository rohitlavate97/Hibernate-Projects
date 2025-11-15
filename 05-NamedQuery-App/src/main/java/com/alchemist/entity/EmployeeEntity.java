package com.alchemist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_DTLS")
@NamedQuery(name = "query1",query = "FROM EmployeeEntity e Where e.deptNumber=?1")
@NamedNativeQuery(name = "query2",query = "select * from EMPLOYEE_DTLS where sal>?",resultClass = EmployeeEntity.class)
public class EmployeeEntity {
	@Id
	@Column(name = "empno")
	private Integer empNumber;
	@Column(name = "ename")
	private String empName;
	@Column(name = "sal")
	private Double salary;
	@Column(name = "deptno")
	private Integer deptNumber;
	public Integer getEmpNumber() {
		return empNumber;
	}
	public void setEmpNumber(Integer empNumber) {
		this.empNumber = empNumber;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Integer getDeptNumber() {
		return deptNumber;
	}
	public void setDeptNumber(Integer deptNumber) {
		this.deptNumber = deptNumber;
	}
	@Override
	public String toString() {
		return "EmployeeEntity [empNumber=" + empNumber + ", empName=" + empName + ", salary=" + salary
				+ ", deptNumber=" + deptNumber + "]";
	}
}
