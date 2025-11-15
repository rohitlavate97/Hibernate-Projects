package com.alchemist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;


import com.alchemist.entity.EmployeeEntity;

public class EmpDaoImpl implements EmpDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("employee");

	@Override
	public List<EmployeeEntity> executeNamedQuery(int deptNo) {
		EntityManager em = factory.createEntityManager();
		TypedQuery<EmployeeEntity> q = em.createNamedQuery("query1", EmployeeEntity.class);
		q.setParameter(1, deptNo);
		List<EmployeeEntity> resultList = q.getResultList();
		em.close();
		return resultList;
	}

	@Override
	public List<EmployeeEntity> executeNamedQueryForSalary(int sal) {
	    EntityManager em = factory.createEntityManager();
	    try {
	        Query q = em.createNamedQuery("query2");
	        q.setParameter(1, sal);
	        return q.getResultList();   // returns List<EmployeeEntity>
	    } finally {
	        em.close();
	    }
	}



}
