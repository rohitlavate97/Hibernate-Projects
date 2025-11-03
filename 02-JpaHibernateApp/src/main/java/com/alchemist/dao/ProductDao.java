package com.alchemist.dao;

import com.alchemist.entity.ProductEntity;

public interface ProductDao {
	ProductEntity saveProduct(ProductEntity product);
	ProductEntity loadProductById(Integer productId);
	ProductEntity updateProductById(Integer productId,Double new_unitPrice);
	void deleteProductById(Integer productId);
}
