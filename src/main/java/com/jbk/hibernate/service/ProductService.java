package com.jbk.hibernate.service;

import java.util.List;
import java.util.TreeSet;

import com.jbk.hibernate.Dao.ProductDao;
import com.jbk.hibernate.Dao.ProductDao2;
import com.jbk.hibernate.entity.Product;

public class ProductService 
{
	ProductDao productDao = new ProductDao();
	ProductDao2 productDao2 = new ProductDao2();

	public List<Product> getAllProducts()
	{
		return getAllProducts();
	}

	public List<Product> showAllProducts() 
	{
		return productDao.showAllProducts();
	}

	public Product getProductById(long productId)
	{
		return productDao.getProductById(productId);
	}

	public String saveProduct(Product product)
	{
		return productDao.saveProduct(product);
	}

	public String  deleteProduct(long productId)
	{
		return productDao.deleteProduct(productId);
	}

	public String  updateProduct(Product product)
	{
		return productDao.updateProduct(product);
	}

	public List<Product> sortProductsByIdAsc()
	{
		return productDao.sortProductsByIdAsc();
	}
	
	public List<Product> sortProductsByIdDesc()
	{
		return productDao.sortProductsByIdDesc();
	}

	public List<Product> sortProductsByNameAsc()
	{
		return productDao.sortProductsByNameAsc();
	}
	
	public TreeSet<Product> sortProductsByNameDesc()
	{
		return productDao.sortProductsByNameDesc();
	}

	public List<Product>  maxPrice()
	{
		return productDao.maxPrice();
	}

	public double sumOfProductPrice()
	{
		return productDao.sumOfProductPrice();
	}

	public int countOfProducts()
	{
		return productDao.countOfProducts();
	}

	public List<Product> searchProductByName(String string)
	{
		return 	productDao2.searchProductByName(string);
	}

	public List<Product> searchProductByAnyNum(String propertyName,long num)
	{
		return productDao2.searchProductByAnyNum(propertyName, num);
	}
	
	public List<Product> searchProdBetweenPrice(double lowerPrice, double higherPrice)
	{
		return 	productDao2.searchProdBetweenPrice(lowerPrice, higherPrice);	
	}

	public List<Product> searchProductInPrice(double productPrice) 
	{
		return productDao2.searchProductInPrice(productPrice);
	}

	public List<Product> PriceGreaterThanOrEqual(double productPrice) 
	{
	return productDao2.PriceGreaterThanOrEqual(productPrice);	
	}
	
	public List<Product> PriceLessThanOrEqual(double productPrice) 
	{
		return productDao2.PriceLessThanOrEqual(productPrice);	
	}
	
	public List<Product> top3ProdHavingMaxPrice()
	{
		return productDao2.top3ProdHavingMaxPrice();
	}
	
	public List<Product> top3ProdHavingMinPrice()
	{
		return productDao2.top3ProdHavingMinPrice();
	}
	
	public List<Product> sortProductListOnOrder(String propertyName , String sortOrder)
	{
		return productDao.sortProductListOnOrder(propertyName, sortOrder);
	}
	
	public List<Product> getLimitedProductsHavingMaxOrMinValue(String propertyName ,String sortOrder,int maxResults)
	{
		return productDao2.getLimitedProductsHavingMaxOrMinValue(propertyName, sortOrder, maxResults);
	}
	
	
}
