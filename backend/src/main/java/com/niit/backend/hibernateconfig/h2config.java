package com.niit.backend.hibernateconfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.backend.model.UserDetails;

public class h2config {
	@Autowired
	public static SessionFactory getHibernateSessionFactory()
	{
		try{
			
			Configuration cfg = new Configuration();
		    cfg.configure("hibernate.cfg.xml");
		    SessionFactory sessionFactory = cfg.buildSessionFactory();

		    		    
		    return sessionFactory;
 
 
 		}  
		  
		
		catch(Exception e){
			System.out.println("error in finding file"+e.toString());
			return null;
		}
		
		
	}
	

}
