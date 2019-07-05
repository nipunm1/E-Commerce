package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.hibernateconfig.h2config;
import com.niit.backend.model.UserDetails;
import com.niit.backend.model.productDetails;

public class productDetailsDAOImpl implements productDetailsDAO{

	public boolean addProduct(productDetails product) {
		h2config h2 = new h2config();
try{
	SessionFactory sessionFactory = h2.getHibernateSessionFactory();
	Session session = sessionFactory.openSession();
	session.beginTransaction();
	session.save(product);
	session.getTransaction().commit();
	
	
	System.out.println(" productDetailsDAOImpl addproduct Data stored in product Table ");
	return true;
}
catch(Exception e){
	System.out.println("error in addProdctIMPL"+e);
	return false;
}
		
	}

	public boolean deleteProduct(productDetails product) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(product);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is deleted from table");
			return true;
		}
		catch(Exception e){
			System.out.println("error in deleteProdctIMPL"+e);
			return false;	
		}
		
	}

	public boolean UpdateProduct(productDetails product) {
		productDetailsDAO ProductDetailsDAO = new productDetailsDAOImpl();
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//product=ProductDetailsDAO.getproductbyid(03);
			// product.setProductDiscription("");
			// product.setProductImage("");
			 //  product.setProductName("");
			// product.setProductPrice("");
			// product.setProductStock("");
			session.update(product);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is updated from table");
		return true;	
		}
		catch(Exception e){
			System.out.println("UpdateProductIMPL error"+e);
			return false;	
		}
		
	}

	public List<productDetails> getallproduct() {
		List <productDetails>list=null;
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = (List<productDetails>)session.createQuery("from productDetails").list();
			System.out.println(list);
			session.getTransaction().commit();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("error in getting all products"+e);
			return list;	
		}
		
	}

	public productDetails getproductbyid(int ProductID) {
		h2config h2 = new h2config();
		productDetails product=null;
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			product = (productDetails)session.createQuery("from productDetails where ProductID='"+ProductID+"'").uniqueResult();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("getproductbyid error"+e);
		}
		return product;
	}

}
