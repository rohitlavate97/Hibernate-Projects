package com.alchemist.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "PRODUCT_TBL")
public class ProductEntity {
	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "product_name")
	private String productName;
	private Integer quantity;
	@Column(name = "unit_price")
	private Double unitPrice;
	@CreationTimestamp
	@Column(name = "created_on")
	private LocalDate createdOn;
	@UpdateTimestamp
	@Column(name = "update_on")
	private LocalDate updatedOn;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
	
}
