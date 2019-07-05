package com.niit.backend.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.niit.backend.dao.PaymentDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.hibernateconfig.h2config;
import com.niit.backend.model.PaymentDetails;
import com.niit.backend.model.productDetails;

public class PaymentDetailsDAOImpl implements PaymentDetailsDAO {

	public boolean addPayment(PaymentDetails payment) {
		
		System.out.println("  Payment save    ");
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(payment);
			session.getTransaction().commit();
			
			
			System.out.println(" PaymentDetailsDAOImpl addPayment Data stored in payment Table ");
			return true;
		}
		catch(Exception e){
			System.out.println("addpayment error"+e);
			return false;
		}
		
	}

	public boolean deletePayment(PaymentDetails payment) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(payment);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is deleted from table");
			return true;
		}
		catch(Exception e){
			System.out.println("deletepayment error"+ e);
			return false;	
		}
		
	}

	public boolean updatePayment(PaymentDetails payment) {
		PaymentDetailsDAO paymentDetailsDAO = new PaymentDetailsDAOImpl();
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//payment=paymentDetailsDAO.getamountbyid(04);
			
			//payment.setPaymentType("credit card");
			session.update(payment);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is updated from table");
			return true;
		}
		catch(Exception e){
			System.out.println("error in updatePayment"+e);
			return false;
		}
		
	}

	public List<PaymentDetails> getallpayment() {
		List <PaymentDetails>list=null;
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = (List<PaymentDetails>)session.createQuery("from PaymentDetails").list();
			System.out.println(list);
			session.getTransaction().commit();
			session.close();
			return list;
		}
		catch(Exception e){
			System.out.println("list in payment error"+e);
			return list;
		}
		
	}

	public PaymentDetails getamountbyid(int paymentDetailsId) {
		h2config h2 = new h2config();
		PaymentDetails payment=null;
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			payment = (PaymentDetails)session.createQuery("from PaymentDetails where paymentDetailsId='"+paymentDetailsId+"'").uniqueResult();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("error in paymentid "+e);
		}
		return payment;
	}

}
