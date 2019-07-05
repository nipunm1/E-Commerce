package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.backend.dao.SupplierDetailsDAO;
import com.niit.backend.hibernateconfig.h2config;
import com.niit.backend.model.SupplierDetails;
import com.niit.backend.model.productDetails;

public class SupplierDetailsDAOImpl implements SupplierDetailsDAO {

	public boolean addSupplier(SupplierDetails supplier) {
		
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(supplier);
			session.getTransaction().commit();
			
			
			System.out.println(" SupplierDetailsDAOImpl addsupplier Data stored in supplier Table ");
			
			return true;
		}
		catch(Exception e){
			System.out.println("addsupplier error"+e);
			return false;
		}
	}

	public boolean deleteSupplier(SupplierDetails supplier) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(supplier);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is deleted from table");
			return true;
		}
		catch(Exception e){
			System.out.println("deletesupplier error"+e);
			return false;
		}
	}

	public boolean UpdateSupplier(SupplierDetails supplier) {
		SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//supplier=supplierdetailsdao.getsupplierbyid(01);
			//supplier.setSupplierName("harsih");
			//supplier.setSupplierAddress("shalimar bagh");
			//supplier.setSupplierEmail("abc@gmail.com");
			//supplier.setSupplierNumber("9999999");
			session.update(supplier);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is updated from table");
			return true;
		}
		catch(Exception e){
			System.out.println("updatesupplier error"+e);
			return false;	
		}
	}

	public List<SupplierDetails> getallSupplier() {
		List <SupplierDetails>list=null;
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = (List<SupplierDetails>)session.createQuery("from SupplierDetails").list();
			System.out.println(list);
			session.getTransaction().commit();
			session.close();
			return list;	
		}
		catch(Exception e){
			System.out.println("SupplierDetails list error"+e);
			return list;
		}
	}

	public SupplierDetails getsupplierbyid(int SupplierID) {
		h2config h2 = new h2config();
		SupplierDetails supplier=null;
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			supplier = (SupplierDetails)session.createQuery("from SupplierDetails where SupplierID='"+SupplierID+"'").uniqueResult();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("getsupplierbyid error"+e);
		}
		return supplier;
	}
}
