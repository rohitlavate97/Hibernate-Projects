package com.alchemist.constants;

public class AppConstants {
	public static final String QUERY_InsertEmployee = "INSERT INTO EMPLOYEE_DTLS (empno, ename, sal, deptno) VALUES (?, ?, ?, ?)";
	public static final String QUERY_fetchEmployeeById = "From EmployeeEntity e where e.empNumber=?1";
	public static final String QUERY_fetchEmployee = "From EmployeeEntity e";
	public static final String QUERY_fetchNamesAndSalaries = "select e.empName, e.salary from EmployeeEntity e";
}
