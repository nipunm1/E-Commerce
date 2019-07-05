package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.backend.dao.CartDetailsDAO;
import com.niit.backend.dao.CategoryDetailsDAO;
import com.niit.backend.hibernateconfig.h2config;
import com.niit.backend.model.CartDetails;
import com.niit.backend.model.CategoryDetails;

public class CartDetailsDAOImpl implements CartDetailsDAO {

	
	public boolean addCart(CartDetails cart) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			cart.setCarttran('n');
			//cart.setCarttran('y');
			session.save(cart);
			session.getTransaction().commit();
			System.out.println("data added to cart table");
			return true;
		}
		catch(Exception e){
			System.out.println("addCart error"+e);
			return false;	
		}
		
	}

	
	public boolean deleteCart(CartDetails cart) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(cart);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is deleted from table");
			return true;
		}
		catch(Exception e){
			System.out.println("deleteCart error"+e);
			return false;
		}
		
	}

	
	public boolean updateCart(CartDetails cart) {
		CartDetailsDAO cartDetailsDAO = new CartDetailsDAOImpl();
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			cart=cartDetailsDAO.getcartbyid(01);
			cart.setCartItems("jeans");
			cart.setCartQuantity(5);
			cart.setCartTotalAmount(5000);
			
			session.update(cart);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is updated from table");
			return true;
		}
		catch(Exception e){
			System.out.println("updatecart error"+e);
			return false;
		}
		
	}

	
	public List<CartDetails> getallCart() {
		List <CartDetails>list=null;
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = (List<CartDetails>)session.createQuery("from CartDetails").list();
			System.out.println(list);
			session.getTransaction().commit();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("ListCart error"+e);
			return list;
		}
		
	}

	
	public CartDetails getcartbyid(int CartId) {
		h2config h2 = new h2config();
		CartDetails cart=null;
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			cart = (CartDetails)session.createQuery("from CartDetails where CartId='"+CartId+"'").uniqueResult();
			session.getTransaction().commit();
			session.close();
			return cart;
		}
		catch(Exception e){
			System.out.println("getcartbyid error"+e);
			return cart;
		}
		
	}

}
