package com.alchemist.dao;

import java.util.List;

import com.alchemist.entity.EmployeeEntity;

public interface EmployeeDao {
	void insertEmployee(EmployeeEntity employee);
	void insertEmployeeUsingNativeQuery(Integer empNo, String empName, Double salary, Integer deptNo);
	EmployeeEntity fetchEmployeeById(Integer empno);
	List<EmployeeEntity> fetchEmployee();
	List<Object[]> fetchNamesAndSalaries();
}
