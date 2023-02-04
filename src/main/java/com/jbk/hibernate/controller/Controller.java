package com.jbk.hibernate.controller;

import java.util.Scanner;

import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.ProductService;
import com.jbk.hibernate.utility.ProductUtility;

public class Controller
{	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		ProductService productService = new ProductService();
		char ch;
		Product product;
		long productId;
		Product updatedProduct;
		String productName;
		double lowerPrice;
		double higherPrice ;
		double productPrice;
		String propertyName ;
		String sortOrder;

		do 
		{
			System.out.println(" 1 . To save a product");
			System.out.println(" 2 . To delete a product");
			System.out.println(" 3 . To get all products");
			System.out.println(" 4 . To get product by Id");
			System.out.println(" 5 . To update product");
			System.out.println(" 6 . To sort products by Id - Asc");
			System.out.println(" 7 . To sort products by Id - Desc");
			System.out.println(" 8 . To sort products by name - Asc");
			System.out.println(" 9 . To sort products by name - Desc");
			System.out.println("10 . To get max price products");
			System.out.println("11 . To count sum of product price");
			System.out.println("12 . To get total count of products");
			System.out.println("13 . To search products by its name");
			System.out.println("14 . To search products between  given price ");
			System.out.println("15 . To search products in given price ");
			System.out.println("16 . To search products whose price is Greater Than Or Equal to  given price ");
			System.out.println("17 . To search products whose price is Less Than Or Equal to  given price ");
			System.out.println("18 . To get Top 3 Products whose Price is Max.");
			System.out.println("19 . To get Top 3 Products whose Price is Min.");
			System.out.println("20 . To Search Product");
			System.out.println("21 . To get Products On Sorting Order(Ase/Desc) ");
			System.out.println("22 . To get Max/Min. Products  ");
                        System.out.println("22 . Task1 for github  ");
			int choice=scanner.nextInt();

			switch(choice)
			{

			case 1:
			{
				product = ProductUtility.prepareProduct(scanner);
				productService.saveProduct(product);
				break;
			}
			case 2:
			{
				productId = ProductUtility.prepareProductId(scanner);
				productService.deleteProduct(productId);
				break;
			}
			case 3:
			{
				productService.showAllProducts();
				break;
			}
			case 4:
			{
				productId = ProductUtility.prepareProductId(scanner);
				productService.getProductById(productId);
				break;
			}
			case 5:
			{
				updatedProduct = ProductUtility.prepareProduct(scanner);
				productService.updateProduct(updatedProduct);
				break;
			}
			case 6:
			{
				productService.sortProductsByIdAsc();
				break;
			}
			case 7:
			{
				productService.sortProductsByIdDesc();
				break;
			}
			case 8:
			{
				productService.sortProductsByNameAsc();
				break;
			}
			case 9:
			{
				productService.sortProductsByNameDesc();
				break;
			}
			case 10:
			{
				productService.maxPrice();
				break;
			}
			case 11:
			{
				productService.sumOfProductPrice();
				break;
			}
			case 12:
			{
				productService.countOfProducts();
				break;
			}
			case 13:
			{
				productName = ProductUtility.prepareProductName(scanner);
				productService.searchProductByName(productName);
				break;
			}
			case 14:
			{
				System.out.println("Enter Lower Price : ");
				lowerPrice = scanner.nextDouble();
				System.out.println("Enter higher Price : ");
				higherPrice = scanner.nextDouble();
				productService.searchProdBetweenPrice(lowerPrice,higherPrice);
				break;
			}
			case 15:
			{
				productPrice = ProductUtility.prepareProductPrice(scanner);
				productService.searchProductInPrice(productPrice);
				break;
			}
			case 16:	
			{
				productPrice =  ProductUtility.prepareProductPrice(scanner);
				productService.PriceGreaterThanOrEqual(productPrice);
				break;
			}
			case 17:
			{
				productPrice =  ProductUtility.prepareProductPrice(scanner);
				productService.PriceLessThanOrEqual(productPrice);
				break;
			}
			case 18:
			{
				productService.top3ProdHavingMaxPrice();
				break;
			}
			case 19:
			{
				productService.top3ProdHavingMinPrice();
				break;
			}
			case 20:
			{	
				System.out.println("Based On Who You Want To Search For...");
				propertyName =ProductUtility.selectProperty(scanner);
				if(propertyName.equalsIgnoreCase("productName"))
				{
					String productName1 = ProductUtility.prepareProductName(scanner);
					productService.searchProductByName(productName1);
				}else
				{
					long value =ProductUtility.randomValueForSearching(scanner);
					productService.searchProductByAnyNum(propertyName, value);
				}
				break;
			}
			case 21:
			{	
				System.out.println("Based On Who You Want To Sort For...");
				propertyName =ProductUtility.selectProperty(scanner);
				sortOrder = ProductUtility.selectSortingOrder(scanner);
				productService.sortProductListOnOrder(propertyName, sortOrder);
				break;
			}
			case 22:
			{	
				System.out.println("Based On Who You Want To Get Mx/Min. Products...");
				propertyName =ProductUtility.selectProperty(scanner);
				sortOrder = ProductUtility.setMaxOrMinResults(scanner);
				int maxResults = ProductUtility.setLimit(scanner);
				productService.getLimitedProductsHavingMaxOrMinValue(propertyName, sortOrder, maxResults);
				break;
			}
			default:
				System.out.println("choose valid option");
				break;
			}	

			System.out.println("Do you want to continue : y/n");

			ch =scanner.next().charAt(0);
		}
		while(ch=='y'|| ch=='Y');

		System.out.println("!!!...Terminated...!!!");
	}
}
