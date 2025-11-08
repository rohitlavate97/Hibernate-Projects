package com.alchemist.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.alchemist.entity.StudentCompositeKey;
import com.alchemist.entity.StudentEntity;

public class StudentDaoImpl implements StudentDao{
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("students");

	@Override
	public void saveStudent(StudentEntity entity) {
		// TODO Auto-generated method stub
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		try {
			entityManager.persist(entity);
			tx.commit();
			System.out.println("Student is saved into DB.....");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			tx.rollback();
			System.out.println("Issue in persisting Student to DB.....");
		}
		finally {
			entityManager.close();
		}
	}

	@Override
	public StudentEntity fetchStudent(StudentCompositeKey key) {
		// TODO Auto-generated method stub
		EntityManager entityManager = factory.createEntityManager();
		//EntityTransaction tx = entityManager.getTransaction();
		StudentEntity student = entityManager.find(StudentEntity.class, key);
		entityManager.close();
		return student;
	}

}
