package com.jbk.hibernate.service;

import java.util.Comparator;

import com.jbk.hibernate.entity.Product;

public class MyComparator implements Comparator<Product>
{

	public int compare(Product obj1, Product obj2) 
	{
		String productName1=obj1.getProductName();
		String productName2=obj2.getProductName();
		int productId1 =(int) obj1.getProductId();
		int productId2 =(int) obj2.getProductId();
		
		if(productName1.equalsIgnoreCase(productName2))
		{
		//	return obj1.compareTo(obj2);
			return productId1-productId2;
		}
		else
		{
		return -productName1.compareTo(productName2);
		}
	}

}
