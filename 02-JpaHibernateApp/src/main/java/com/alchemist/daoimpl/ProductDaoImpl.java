package com.alchemist.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.alchemist.dao.ProductDao;
import com.alchemist.entity.ProductEntity;

public class ProductDaoImpl implements ProductDao {

	private EntityManagerFactory factory;
	
	public ProductDaoImpl() {
		factory = Persistence.createEntityManagerFactory("products");
	}

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			entityManager.persist(product);
			tx.commit();
			System.out.println("Product is inserted in DB");
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Error in inserting a product in db...." + e);
		} finally {
			entityManager.close();
		}
		return product;
	}

	@Override
	public ProductEntity loadProductById(Integer productId) {
		EntityManager entityManager = factory.createEntityManager();
		/*
		 * find(): Early load getReference(): Lazy Load
		 */
		ProductEntity product = entityManager.find(ProductEntity.class, productId);
		entityManager.close();
		return product;
	}

	@Override
	public ProductEntity updateProductById(Integer productId, Double new_unitPrice) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity product = entityManager.find(ProductEntity.class, productId);
		if (product == null) {
			System.out.println("Product ID not found: " + productId);
			return null;
		}
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		product.setUnitPrice(new_unitPrice);
		tx.commit();
		entityManager.close();
		return product;
	}

	@Override
	public void deleteProductById(Integer productId) {
		EntityManager entityManager = factory.createEntityManager();
		ProductEntity product = entityManager.find(ProductEntity.class, productId);
		if (product == null) {
			System.out.println("Product ID not found: " + productId);
			return;
		}
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.remove(product);
		tx.commit();
		entityManager.close();
		System.out.println("🗑️ Deleted product: " + productId);
	}
	
	public void closeFactory() {
	    if (factory != null && factory.isOpen()) {
	        factory.close();
	        System.out.println("EntityManagerFactory closed successfully.");
	    } else {
	        System.out.println("EntityManagerFactory already closed or null.");
	    }
	}

	@Override
	public void testEntityStates() {
		EntityManager entityManager = factory.createEntityManager();
		
		ProductEntity pe = new ProductEntity();           //Transient State
		pe.setProductId(123);
		pe.setProductName("earbuds");
		pe.setQuantity(3);
		pe.setUnitPrice(2000.00);
		/*
		 * EntityTransaction tx = entityManager.getTransaction(); 
		 * tx.begin();
		 * entityManager.persist(pe); // persistence state 
		 * tx.commit();
		 * 
		 * entityManager.detach(pe); //Removed from cache 
		 * pe.setUnitPrice(3100.00);
		 * //changes made to an entity in detached state does not affect in db
		 * entityManager.close();
		 */
		
		ProductEntity entity = entityManager.find(ProductEntity.class, 123);  //entity is in persistence state(as loading from db)
		entityManager.detach(entity);                                         //detached state
		entity.setUnitPrice(3000.00);
		
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(entity);                                          //Moved from detailed to persistence state
		tx.commit();
		entityManager.close();
		
	}


}
