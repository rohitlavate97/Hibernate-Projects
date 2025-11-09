package com.alchemist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.alchemist.constants.AppConstants;
import com.alchemist.entity.EmployeeEntity;

public class EmployeeDaoImpl implements EmployeeDao{
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("emp");
	
	@Override
	public void insertEmployee(EmployeeEntity employee) {
	    EntityManager entityManager = factory.createEntityManager();
	    entityManager.getTransaction().begin();
	    entityManager.persist(employee);
	    entityManager.getTransaction().commit();
	    entityManager.close();
	}
	
	@Override
	public void insertEmployeeUsingNativeQuery(Integer empNo, String empName, Double salary, Integer deptNo) {
		 EntityManager entityManager = factory.createEntityManager();
		    try {
		        entityManager.getTransaction().begin();
		        
		        entityManager.createNativeQuery(
		            AppConstants.QUERY_InsertEmployee)
		            .setParameter(1, empNo)
		            .setParameter(2, empName)
		            .setParameter(3, salary)
		            .setParameter(4, deptNo)
		            .executeUpdate();
		        
		        entityManager.getTransaction().commit();
		        System.out.println("✅ Employee inserted successfully!");
		    } catch (Exception e) {
		        entityManager.getTransaction().rollback();
		        e.printStackTrace();
		        System.err.println("❌ Failed to insert employee: " + e.getMessage());
		    } finally {
		        entityManager.close();
		    }
		
	}
	
	@Override
	public EmployeeEntity fetchEmployeeById(Integer empno) {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<EmployeeEntity> tq = entityManager
				                 .createQuery(AppConstants.QUERY_fetchEmployeeById, EmployeeEntity.class);
		tq.setParameter(1, empno);
		EmployeeEntity e = tq.getSingleResult();
		entityManager.close();
		return e;
	}

	@Override
	public List<EmployeeEntity> fetchEmployee() {
		EntityManager entityManager = factory.createEntityManager();
		TypedQuery<EmployeeEntity> tq = entityManager.createQuery(AppConstants.QUERY_fetchEmployee, EmployeeEntity.class);
		List<EmployeeEntity> lstOfEmployees = tq.getResultList();
		entityManager.close();
		return lstOfEmployees;
	}

	@Override
	public List<Object[]> fetchNamesAndSalaries() {
		EntityManager em = factory.createEntityManager();
		TypedQuery<Object[]> tq = em.createQuery(AppConstants.QUERY_fetchNamesAndSalaries, Object[].class);
		List<Object[]> lst = tq.getResultList();
		em.close();
		return lst;
	}

}
