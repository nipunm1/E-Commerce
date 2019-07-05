package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.backend.dao.CategoryDetailsDAO;
import com.niit.backend.dao.PaymentDetailsDAO;
import com.niit.backend.hibernateconfig.h2config;
import com.niit.backend.model.CategoryDetails;
import com.niit.backend.model.PaymentDetails;

public class CategoryDetailsDAOImpl implements CategoryDetailsDAO{

	
	public boolean addCategory(CategoryDetails category) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(category);
			session.getTransaction().commit();
			System.out.println("data added to category table");
			return true;
		}
		catch(Exception e){
			System.out.println("addCategory error"+e);
			return false;
		}
		
	}

	
	public boolean deleteCategory(CategoryDetails category) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(category);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is deleted from table");
			return true;
		}
		catch(Exception e){
			System.out.println("deletecategory error"+e);
			return false;	
		}
		
	}

	
	public boolean updateCategory(CategoryDetails category) {
		CategoryDetailsDAO categoryDetailsDAO = new CategoryDetailsDAOImpl();
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//category=categoryDetailsDAO.getcategorybyid(36);
			//category.setCategoryName("socks");
			session.update(category);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is updated from table");
			return true;
		}
		catch(Exception e){
			System.out.println("updatecategory error"+e);
			return false;	
		}
		
	}

	
	public List<CategoryDetails> getallCategory() {
		List <CategoryDetails>list=null;
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = (List<CategoryDetails>)session.createQuery("from CategoryDetails").list();
			System.out.println(list);
			session.getTransaction().commit();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("getallcategory error"+e);
			return list;
		}
		
	}

	
	public CategoryDetails getcategorybyid(int CategoryId) {
		h2config h2 = new h2config();
		CategoryDetails category=null;
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			category = (CategoryDetails)session.createQuery("from CategoryDetails where CategoryId='"+CategoryId+"'").uniqueResult();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("getcategorybyid error"+e);
		}
		return category;
	}

}
