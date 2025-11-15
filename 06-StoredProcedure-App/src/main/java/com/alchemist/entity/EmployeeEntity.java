package com.alchemist.entity;

import javax.persistence.*;

@Entity
@Table(name = "emp")
@NamedStoredProcedureQuery(
        name = "emp_experience_proc",
        procedureName = "EMP_EXPERIENCE",

        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,  name = "ENO",        type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "NAME",       type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "EXPERIENCE", type = Double.class)
        }
)
public class EmployeeEntity {

    @Id
    @Column(name = "EMPNO")
    private int empNo;

    @Column(name = "ENAME")
    private String ename;

    @Column(name = "SAL")
    private double sal;

    @Column(name = "DEPTNO")
    private int deptNo;

    @Column(name = "DOJ")
    private java.sql.Date doj;

    @Column(name = "MGR")
    private Integer mgr;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public java.sql.Date getDoj() {
		return doj;
	}

	public void setDoj(java.sql.Date doj) {
		this.doj = doj;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [empNo=" + empNo + ", ename=" + ename + ", sal=" + sal + ", deptNo=" + deptNo + ", doj="
				+ doj + ", mgr=" + mgr + "]";
	}
      
}
