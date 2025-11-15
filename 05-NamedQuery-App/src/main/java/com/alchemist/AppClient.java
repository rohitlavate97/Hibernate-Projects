package com.alchemist;

import java.util.List;

import com.alchemist.dao.*;
import com.alchemist.entity.EmployeeEntity;

public class AppClient {
    public static void main(String[] args) {
        EmpDao dao = new EmpDaoImpl();
        
        List<EmployeeEntity> executeNamedQuery = dao.executeNamedQuery(1);
        executeNamedQuery.forEach(System.out::println);
        
        System.out.println("----------------------------------------");
        
        List<EmployeeEntity> executeNamedQueryForSalary = dao.executeNamedQueryForSalary(54000);
        executeNamedQueryForSalary.forEach(System.out::println);
        
    }
}
