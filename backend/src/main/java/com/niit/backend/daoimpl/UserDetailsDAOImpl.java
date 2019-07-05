package com.niit.backend.daoimpl;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.hibernateconfig.h2config;
import com.niit.backend.model.UserDetails;

public class UserDetailsDAOImpl implements UserDetailsDAO{

	public boolean addUser(UserDetails user) {
h2config h2 = new h2config();
		
		try
		{
		SessionFactory sessionFactory = h2.getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		user.setUserRole("normal user");
		user.setUserStatus("no");
		session.save(user);
		session.getTransaction().commit();
		
		
		System.out.println(" UserDetailsDAOImpl adduser Data stored in User Table ");
		return true;
		}
		catch(Exception e)
		{
			System.out.println(" UserDetailsDAOImpl adduser  "+e);
			
			return false;
		}
	}

	public boolean deleteUser(UserDetails user) {
		h2config h2 = new h2config();
		try{
			
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is deleted from table");
			return true;
		}
		catch(Exception e){
			System.out.println(" UserDetailsDAOImpl deleteuser"+ e);
			return false;		
		}
	}

	public boolean UpdateUser(UserDetails user) {
		UserDetailsDAO dao = new UserDetailsDAOImpl();
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			user= dao.getuserbyemail("niit@niit.com");
			// user.setUserName("");
			 // user.setUserMobile("");
			 //user.setUserAddress("azad market");
			// user.setUserAadharId("");
			// user.setUserPassword("");
			session.update(user);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is updated from table");
			return true;
		}
		catch(Exception e){
			System.out.println("UserDetailsDAOImpl updateuser"+ e);
			return false;	
		}
	}

	public List<UserDetails> getalluser() {
		List <UserDetails>list=null;
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = (List<UserDetails>)session.createQuery("from UserDetails").list();
			System.out.println(list);
			session.getTransaction().commit();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("error in list"+ e);
			return list;
		}
		
	}

	public UserDetails getuserbyemail(String UserEmail) {
		h2config h2 = new h2config();
		UserDetails user=null;
		
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
		 user = (UserDetails)session.createQuery("from UserDetails where  UserEmail='"+UserEmail+"'").uniqueResult();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("error in getting email"+ e);
		}
		return user;
	}
}