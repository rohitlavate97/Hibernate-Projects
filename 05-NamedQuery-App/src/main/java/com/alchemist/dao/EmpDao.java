package com.alchemist.dao;

import java.util.List;

import com.alchemist.entity.EmployeeEntity;

public interface EmpDao {
	List<EmployeeEntity> executeNamedQuery(int deptNo);
	List<EmployeeEntity> executeNamedQueryForSalary(int sal);
	List<EmployeeEntity> executeCriteriaQuery();
	List<EmployeeEntity> executeCriteriaQueryForlessAndGreaterThan();
	List<EmployeeEntity> executeCriteriaQueryForInBetweenSalary();
}
