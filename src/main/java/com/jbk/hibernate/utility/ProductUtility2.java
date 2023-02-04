package com.jbk.hibernate.utility;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;

public class ProductUtility2
{
	public static Product prepareProduct(Scanner scanner)
	{
		long productId=0;
		String productName=null;
		long supplierId=0;
		long categoryId=0;
		int productQty=0;
		double productPrice=0;

		boolean isWork =true;

			do
			{
				try
				{
					System.out.println("Enter ProductId : ");
					productId = scanner.nextLong();
					
				}
				catch(Exception e)
				{
					
					System.out.println("Please Provide Valid Data");
				}
				isWork=false;
			}while(isWork);
			
			try
			{
				System.out.println("Enter ProductName : ");
				productName = scanner.next();
			}
			catch(Exception e)
			{
				System.out.println("Please Provide Valid Data");
			}
			try
			{
				System.out.println("Enter supplierId : ");
				supplierId = scanner.nextLong();
			}
			catch(Exception e)
			{
				System.out.println("Please Provide Valid Data");
			}
			try
			{
				System.out.println("Enter categoryId : ");
				categoryId = scanner.nextLong();
			}
			catch(Exception e)
			{
				System.out.println("Please Provide Valid Data");
			}
			try
			{
				System.out.println("Enter ProductQty : ");
				productQty = scanner.nextInt();
			}
			catch(Exception e)
			{
				System.out.println("Please Provide Valid Data");
			}
			try
			{
				System.out.println("Enter ProductPrice : ");
				productPrice = scanner.nextDouble();
			}
			catch(Exception e)
			{
				System.out.println("Please Provide Valid Data");
			}
			Product product = new Product( productId, productName,supplierId, categoryId, productQty, productPrice);

			isWork=false;
			return product;
	}
	
	public static long prepareProductId(Scanner scanner)
	{		
		System.out.println("Enter ProductId : ");
		long productId = scanner.nextLong();

		return productId;
	}
}
