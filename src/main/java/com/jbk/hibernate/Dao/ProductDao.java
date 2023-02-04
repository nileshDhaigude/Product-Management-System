package com.jbk.hibernate.Dao;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.jbk.hibernate.config.HibernateConfig;
import com.jbk.hibernate.entity.Product;
import com.jbk.hibernate.service.MyComparator;

public class ProductDao 
{
	//ProductDao productDao = new ProductDao();
	
	static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public static List<Product> getAllProducts()
	{
		Session session = sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			List<Product> list = criteria.list();
			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return null;
	}

	public List<?> getAllProductsbyCriteriaBuilder()
	{
		//...........Not works........//

		Session session = sessionFactory.openSession();
		try
		{
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Product> criteria2 = builder.createQuery(Product.class);
			List<?> list = criteria2.getOrderList();
			//List<Expression<?>> list1 =	criteria2.getGroupList();
			for (Object object : list)
			{
				System.out.println(object);	
			}

			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return null;
	}

	public List<Product> showAllProducts()
	{
		List<Product> list = getAllProducts();
		for(Product product :list)
		{
			System.out.println(product);
		}

		return list;
	}

	public Product getProductById(long productId)
	{
		Session session = sessionFactory.openSession();
		try
		{
			Product product = session.load(Product.class, productId);

			//     Product product =	session.get(Product.class, productId);

			if(product!=null)
			{
				System.out.println(product);
				return product;
			}
			else
			{
				System.out.println("Product Not Exist !! Id = "+productId);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			session.close();
		}
		return null;
	}

	public String saveProduct(Product product)
	{
		Product dbProduct= getProductById(product.getProductId());
		Session session = sessionFactory.openSession();
		try
		{
			if(dbProduct==null)
			{
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();

				System.out.println("Product Added");
				return "Product Added";
			}
			else
			{
				System.out.println("Product is already Exist "+product.getProductId());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			session.close();
		}
		return "Product is already Exist "+product.getProductId();
	}

	public String  deleteProduct(long productId)
	{		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try
		{
			Product dbProduct = getProductById(productId);

			if(dbProduct!=null)
			{
				//	Product product = session.load(Product.class, productId);
				//	session.delete(product);;
				session.delete(dbProduct);;

				transaction.commit();	
				System.out.println("Product Deleted");
				return "Product Deleted";
			}
			else
			{
				System.out.println(" ProductId Does Not Exists !! Id = "+productId);
				return " ProductId Does Not Exists !! Id = "+productId;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{

			session.close();
		}
		return null;
	}

	public String  updateProduct(Product product)
	{		
		Product dbProduct= getProductById(product.getProductId());
		Session session = sessionFactory.openSession();

		try
		{
			if(dbProduct!=null)
			{
				Transaction transaction = session.beginTransaction();
				session.update(product);
				transaction.commit();	
				System.out.println("Product Updated");
				return "Product updated";	
			}
			else
			{
				System.out.println("product is Not Available To Updated");
				return "product is Not Available To Updated";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return null;
	}

	public List<Product> sortProductsByIdAsc()
	{
		try
		{
			List<Product> list = getAllProducts();
			//			Session session = sessionFactory.openSession();
			//				Criteria criteria = session.createCriteria(Product.class);
			//
			//				criteria.addOrder(Order.asc("productId"));
			//				List<Product> list1 = criteria.list();

			if(!list.isEmpty())
			{
				Collections.sort(list);
				for (Product product : list) 
				{
					System.out.println(product);
				}
				return list;
			}
			else
			{
				System.out.println("List is Empty");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> sortProductsByIdDesc()
	{
		Session session = sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);

			criteria.addOrder(Order.desc("productId"));
			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);
				}
				return list;
			}
			else
			{
				System.out.println("List is Empty");
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return null;
	}

	public List<Product> sortProductsByNameAsc()
	{
		Session session = sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria("Product.class");
			criteria.addOrder(Order.asc("productName"));
			List<Product> list =criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);
				}
				return list;
			}
			else
			{
				System.out.println("List is Empty");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public TreeSet<Product> sortProductsByNameDesc()
	{
		try
		{
			List<Product> list = getAllProducts();
			if(!list.isEmpty())
			{
				TreeSet<Product> treeset = new TreeSet<Product>(new MyComparator());
				treeset.addAll(list);

				for (Product product : treeset) 
				{
					System.out.println(product);
				}
				return treeset;
			}
			else
			{
				System.out.println("List is Empty");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public List<Product>  maxPrice()
	{
		try
		{
			List<Product> list = getAllProducts();

			if(!list.isEmpty())
			{
				double maxprice= list.stream().max((product1,product2)->(int) product1.getProductPrice()- (int) product2.getProductPrice()).get().getProductPrice();			

				for (Product product : list)
				{
					if(product.getProductPrice()==maxprice)
					{
						System.out.println(product);
					}
				}	
			}
			else
			{
				System.out.println("List is Empty");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public double sumOfProductPrice()
	{
		try
		{
			List<Product> list = getAllProducts();
			if(!list.isEmpty())
			{
				double sum=0;
				for (Product product : list)
				{
					sum=sum+product.getProductPrice();
				}	
				System.out.println("sum of all product : " +sum);
				return sum;
			}
			else
			{
				System.out.println("List is Empty");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public int countOfProducts()
	{
		try
		{
			List<Product> list = getAllProducts();
			if(!list.isEmpty())
			{
				int count=0;
				for (Product product : list)
				{		
					count=count+product.getProductQty();
				}	
				System.out.println("count of all products : " +count);
				return count;
			}
			else
			{
				System.out.println("List is Empty");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public List<Product> sortProductListOnOrder(String propertyName , String sortOrder)
	{
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try
		{
			Criteria criteria = session.createCriteria(Product.class);

			if(sortOrder.startsWith("A") || sortOrder.startsWith("a"))
			{
				criteria.addOrder(Order.asc(propertyName));
				list = criteria.list();
			}
			else if(sortOrder.startsWith("D") || sortOrder.startsWith("d"))
			{
				criteria.addOrder(Order.desc(propertyName));
				list = criteria.list();
			}
			else
			{
				System.out.println("Please Provide Valid Sorting Order");
			}
			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);
				}
				return list;
			}
			else
			{
				System.out.println("List is Empty");
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return null;
	}

}
