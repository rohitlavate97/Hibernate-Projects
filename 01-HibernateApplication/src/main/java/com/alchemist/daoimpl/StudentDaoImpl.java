package com.alchemist.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.alchemist.dao.StudentDao;
import com.alchemist.entity.Student;

public class StudentDaoImpl implements StudentDao {

	// Declare a SessionFactory (heavyweight object - shared across the application)
	private SessionFactory factory;

	// Constructor: Initializes Hibernate and builds the SessionFactory
	public StudentDaoImpl() {
		// Step 1: Create a ServiceRegistry — reads hibernate.cfg.xml and applies
		// configuration
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml") // make
																												// sure
																												// the
																												// file
																												// name
																												// is
																												// correct
				.build();

		// Step 2: Create Metadata from the service registry (contains mappings and
		// configuration)
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

		// Step 3: Build the SessionFactory from metadata (used to open sessions)
		factory = metadata.getSessionFactoryBuilder().build();
	}

	@Override
	public void saveStudent(Student student) {
		// Step 4: Open a new Session (lightweight object, not thread-safe)
		Session session = factory.openSession();

		// Step 5: Begin a transaction (required for INSERT/UPDATE/DELETE)
		Transaction t = session.beginTransaction();

		try {
			// Step 6: Save the Student entity to the database
			session.save(student);
			// OR, in Hibernate 6+, you can use: session.persist(student);

			System.out.println("✅ Student object is persisted in the database.");

			// Step 7: Commit the transaction — finalizes the changes in DB
			t.commit();

		} catch (Exception e) {
			// Step 8: If any issue occurs, rollback the transaction to maintain DB
			// integrity
			t.rollback();
			System.out.println("❌ Issue occurred while persisting Student object.");
			e.printStackTrace();
		} finally {
			// Step 9: Close the Session to release JDBC and Hibernate resources
			session.close();

			// Note: Do not close factory here; it should live for the entire app lifecycle.
		}
	}

	@Override
	public Student loadStudent(int sid) {
		// TODO Auto-generated method stub
		/*
		 * load():lazy loading get():early loading args: 1) Classname.class 2) id
		 * value(primary key value)
		 */
		Session session = factory.openSession();
		// Student student = session.get(Student.class, sid); //for early loading-->we
		// can see Select Query in the console
		Student student = session.load(Student.class, sid); // for lazy loading
		try {
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Name of the Student: " + student.getSname());
		session.close(); // Exception while lazy loading so comment it, use only when early loading or
							// add delay to execution
		return student;
	}

	@Override
	public Student updateStudentMarks(int sid, int marks) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Student student = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		try {
			student.setMarks(marks);
			session.update(student);
			t.commit();
			System.out.println("Record is Updated :)");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
			System.out.println("Record is not Updated :(");
		} finally {
			session.close();
		}
		return student;
	}

	@Override
	public void deleteStudent(int sid) {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
		Student student = session.get(Student.class, sid);
		Transaction t = session.beginTransaction();
		try {
			session.delete(student);
			t.commit();
			System.out.println("Record Deleted Successfully: ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			t.rollback();
			System.out.println("Record Deletion Failed");
		}finally {
			session.close();
		}

	}

	@Override
	public void levelOneCacheTest() {
		// TODO Auto-generated method stub
		System.out.println("--Check the console for number of queries");
		Session session = factory.openSession();
		Student s1 = session.get(Student.class, 1);
		Student s2 = session.get(Student.class, 2);
		Student s3 = session.get(Student.class, 1);
		
		Session other_session = factory.openSession();
		Student s4 = other_session.get(Student.class, 1);
	}
}
