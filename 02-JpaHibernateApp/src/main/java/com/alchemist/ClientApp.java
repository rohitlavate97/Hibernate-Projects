package com.alchemist;

import com.alchemist.daoimpl.ProductDaoImpl;
import com.alchemist.entity.ProductEntity;
import com.alchemist.dao.ProductDao;

public class ClientApp {
    public static void main(String[] args) {
        ProductDao dao = new ProductDaoImpl();
        
     // 🔹 Register shutdown hook at application start
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            dao.closeFactory();
            System.out.println("Hibernate closed on JVM shutdown.");
        }));
		
		/*
		 * ProductEntity entity = new ProductEntity(); 
		 * entity.setProductId(4);
		 * entity.setProductName("Graphic Cards"); 
		 * entity.setQuantity(3);
		 * entity.setUnitPrice(15000.00);
		 * 
		 * dao.saveProduct(entity);
		 */
		 
        
        //dao.updateProductById(1, 60000.00);
        ProductEntity product = dao.loadProductById(2);
        System.out.println(product);
        dao.deleteProductById(4);
    }
}
