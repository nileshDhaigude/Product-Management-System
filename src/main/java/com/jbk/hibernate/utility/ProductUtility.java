package com.jbk.hibernate.utility;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;

public class ProductUtility
{
	public static Product prepareProduct(Scanner scanner)
	{
		System.out.println("Enter ProductId : ");
		long productId = scanner.nextLong();

		System.out.println("Enter ProductName : ");
		String productName = scanner.next();

		System.out.println("Enter supplierId : ");
		long supplierId = scanner.nextLong();

		System.out.println("Enter categoryId : ");
		long categoryId = scanner.nextLong();

		System.out.println("Enter ProductQty : ");
		int productQty = scanner.nextInt();

		System.out.println("Enter ProductPrice : ");
		double productPrice = scanner.nextDouble();

		Product product = new Product( productId, productName,supplierId, categoryId, productQty, productPrice);

		return product;
	}

	public static long prepareProductId(Scanner scanner)
	{		
		System.out.println("Enter Product Id : ");
		long productId = scanner.nextLong();
		
		return productId;
	}
	
	public static String prepareProductName(Scanner scanner)
	{		
		System.out.println("Enter Product Name: ");
		String productName = scanner.next();

		return productName;
	}
	
	public static double prepareProductPrice(Scanner scanner)
	{		
		System.out.println("Enter Product Price : ");
		double productPrice = scanner.nextDouble();
		
		return productPrice;
	}
	
	public static int prepareProductQty(Scanner scanner)
	{		
		System.out.println("Enter Product Quantity : ");
		int productQty = scanner.nextInt();
		
		return productQty;
	}
	
	public static long prepareCustomerId(Scanner scanner)
	{		
		System.out.println("Enter Customer Id : ");
		long customerId = scanner.nextLong();
		
		return customerId;
	}
	
	public static long prepareSupplierId(Scanner scanner)
	{		
		System.out.println("Enter Supplier Id : ");
		long supplierId = scanner.nextLong();
		
		return supplierId;
	}

	public static String selectProperty(Scanner scanner)
	{
		System.out.println("Select Property :->");
		System.out.println(" 1. Product Id.");
		System.out.println(" 2. Category Id.");
		System.out.println(" 3. Product Name.");
		System.out.println(" 4. Product Price.");
		System.out.println(" 5. Product Quentity.");
		System.out.println(" 6. Supplier Id.");
		int choice = scanner.nextInt();

		switch(choice)
		{
		case 1:
			return "productId";
		case 2:
			return "categoryId";
		case 3:			
			return "productName";
		case 4:
			return "productPrice";
		case 5:
			return "productQty";
		case 6:
			return "supplierId";
		default :
			System.out.println("Select Valid Property..!!!");
		}
		return null;
	}

	public static long randomValueForSearching(Scanner scanner)
	{
		System.out.println("Enter Number To Search : ");
		long value = scanner.nextLong();
		return value;
	}
	
	public static int setLimit(Scanner scanner)
	{
		System.out.println("Set Limit To Get : ");
		int limit = scanner.nextInt();
		return limit;
	}

    public static String selectSortingOrder(Scanner scanner)
    {
    	System.out.println("select Sorting Order :");
    	System.out.println("1. Ascending Order.");
    	System.out.println("2. Descending Order.");
		int  choice = scanner.nextInt();
    	
		if(choice==1)
		{
			return "Ascending";
		}
		else if(choice==2)
		{
			return "Descending";
		}
		else
		{
			System.out.println("Please Select Valid Sorting Order...!!!");
		}
    	return null;
    }
    
    public static String setMaxOrMinResults(Scanner scanner)
    {
    	System.out.println("select Sorting Order :");
    	System.out.println("1. Min/bottom. Results.");
    	System.out.println("2. Max/Top Results .");
    	int  choice = scanner.nextInt();
    	
    	if(choice==1)
    	{
    		return "Ascending";
    	}
    	else if(choice==2)
    	{
    		return "Descending";
    	}
    	else
    	{
    		System.out.println("Please Select Valid Sorting Order...!!!");
    	}
    	return null;
    }

}
