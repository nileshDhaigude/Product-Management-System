package com.jbk.hibernate.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.jbk.hibernate.config.HibernateConfig;
import com.jbk.hibernate.entity.Product;

public class ProductDao2
{
	static SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public List<Product> searchProductByName(String string)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.like("productName", "%"+string+"%"));
			List<Product> list = criteria.list();
			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("No Such Type Of Product Available...!!!");
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

	public List<Product> searchProdBetweenPrice(double low ,double high)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.between("productPrice", low, high));
			List<Product> list = criteria.list();
			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("No Any Product Available in Between : "+low+" to "+high);
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

	public List<Product> searchProductInPrice(double productPrice)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.in("productPrice", productPrice));
			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("No Any Product Available in Price : "+productPrice);
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

	public List<Product> PriceGreaterThanOrEqual(double productPrice)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.ge("productPrice", productPrice));
			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("No Any Product Available Whose Price is Greater or Equal to : "+productPrice);
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

	public List<Product> PriceLessThanOrEqual(double productPrice)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.le("productPrice", productPrice));
			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("No Any Product Available Whose Price is Less Than or Equal to : "+productPrice);
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

	public List<Product> top3ProdHavingMaxPrice()
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.desc("productPrice"));
			criteria.setMaxResults(3);
			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("List is Empty ");
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

	public List<Product> top3ProdHavingMinPrice()
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productPrice"));
			criteria.setMaxResults(3);
			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("List is Empty ");
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
	
	public List<Product> searchProductByIdOrPrice(String propertyName,long num)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);

			if(propertyName.equalsIgnoreCase("productId") || propertyName.equalsIgnoreCase("categoryId") || propertyName.equalsIgnoreCase("supplierId"))
			{
				criteria.add(Restrictions.like(propertyName,num));
			}
			else if(propertyName.equalsIgnoreCase("productPrice"))
			{
				criteria.add(Restrictions.in(propertyName,(double)num));
			}
			else if (propertyName.equalsIgnoreCase("productQty"))
			{
				criteria.add(Restrictions.like(propertyName,(int)num));
			}

			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("No Such Type Of Product Available...!!!");
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
	
	public List<Product> searchProductByAnyNum(String propertyName,long num)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
						
			criteria.add(Restrictions.sqlRestriction(propertyName+" like '%"+num+"%' "));
			
			List<Product> list = criteria.list();
			
			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("No Such Type Of Product Available...!!!");
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

	public List<Product> getLimitedProductsHavingMaxOrMinValue(String propertyName ,String sortOrder,int maxResults)
	{
		Session session =sessionFactory.openSession();
		try
		{
			Criteria criteria = session.createCriteria(Product.class);
			if(sortOrder.equalsIgnoreCase("Ascending"))
			{
			criteria.addOrder(Order.asc(propertyName));
			}
			else if(sortOrder.equalsIgnoreCase("Descending"))
			{
				criteria.addOrder(Order.desc(propertyName));
			}
			criteria.setMaxResults(maxResults);
			
			List<Product> list = criteria.list();

			if(!list.isEmpty())
			{
				for (Product product : list) 
				{
					System.out.println(product);	
				}
				return list;
			}else
			{
				System.out.println("List is Empty ");
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
