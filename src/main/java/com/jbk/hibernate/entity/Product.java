package com.jbk.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Comparable<Product>
{
	@Id
	private long productId;
	private String productName;
	private long supplierId;
	private long categoryId;
	private int productQty;
	private double productPrice;
    
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, String productName, long supplierId, long categoryId, int productQty,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", categoryId=" + categoryId + ", productQty=" + productQty + ", productPrice=" + productPrice + "]";
	}

	public int compareTo(Product nextProduct) 
	{
		long productid1=this.productId;
		
		long productid2=nextProduct.productId;
		
		if(productid1>productid2)
		{
			return +1;
		}
		else
		{
			return -1;
		}
	}
}
