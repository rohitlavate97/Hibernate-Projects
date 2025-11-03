package com.alchemist;

import com.alchemist.daoimpl.ProductDaoImpl;
import com.alchemist.entity.ProductEntity;
import com.alchemist.dao.ProductDao;

public class ClientApp {
    public static void main(String[] args) {
        ProductDao dao = new ProductDaoImpl();
        
        ProductEntity entity = new ProductEntity();
        entity.setProductId(1);
        entity.setProductName("Laptop");
        entity.setQuantity(3);
        entity.setUnitPrice(50000.00);
        
        dao.saveProduct(entity);
    }
}
