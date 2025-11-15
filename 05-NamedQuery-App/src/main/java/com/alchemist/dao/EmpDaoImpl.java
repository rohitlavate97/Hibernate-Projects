package com.alchemist.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
			return q.getResultList(); // returns List<EmployeeEntity>
		} finally {
			em.close();
		}
	}

	@Override
	public List<EmployeeEntity> executeCriteriaQuery() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> q = cb.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> r = q.from(EmployeeEntity.class);
		q.select(r).where(cb.gt(r.get("salary"), 55000));
		TypedQuery<EmployeeEntity> query = em.createQuery(q);
		List<EmployeeEntity> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public List<EmployeeEntity> executeCriteriaQueryForlessAndGreaterThan() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> q = cb.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> r = q.from(EmployeeEntity.class);
		q.select(r).where(cb.and(cb.gt(r.get("salary"), 52000), cb.lt(r.get("salary"), 58000)));

		List<EmployeeEntity> list = em.createQuery(q).getResultList();
		em.close();
		return list;
	}

	@Override
	public List<EmployeeEntity> executeCriteriaQueryForInBetweenSalary() {
		EntityManager em = factory.createEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EmployeeEntity> q = cb.createQuery(EmployeeEntity.class);
		Root<EmployeeEntity> r = q.from(EmployeeEntity.class);

		q.select(r).where(cb.between(r.get("salary"), 52000, 58000));

		List<EmployeeEntity> list = em.createQuery(q).getResultList();
		em.close();
		return list;
	}

}
