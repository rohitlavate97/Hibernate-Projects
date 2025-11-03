package com.alchemist.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.alchemist.dao.ProductDao;
import com.alchemist.entity.ProductEntity;

public class ProductDaoImpl implements ProductDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("products");

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

}
