package com.alchemist;

import java.util.List;

import com.alchemist.dao.*;
import com.alchemist.entity.EmployeeEntity;

public class ClientApp {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDaoImpl();
        
		/*
		 * EmployeeEntity employee = new EmployeeEntity(); 
		 * employee.setEmpNumber(103);
		 * employee.setEmpName("Ajay"); 
		 * employee.setSalary(55000.00);
		 * employee.setDeptNumber(1);
		 * 
		 * dao.insertEmployee(employee);
		 * 
		 * dao.insertEmployeeUsingNativeQuery(104, "Mayur", 57000.00, 1);
		 */
        EmployeeEntity fetchEmployeeById = dao.fetchEmployeeById(102);
        System.out.println(fetchEmployeeById);
        
        System.out.println("----------------------------------");
        
        List<EmployeeEntity> lst = dao.fetchEmployee();
        lst.forEach(System.out::println);
        
        System.out.println("----------------------------------");
        
        List<Object[]> fetchNamesAndSalaries = dao.fetchNamesAndSalaries();
        fetchNamesAndSalaries.forEach(obj-> 
        System.out.println(obj[0]+" "+obj[1]
        		));
    }
}
