package com.niit.backend.daoimpl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.niit.backend.dao.StockDetailsDAO;
import com.niit.backend.hibernateconfig.h2config;
import com.niit.backend.model.StockDetails;
import com.niit.backend.model.productDetails;


public class StockDetailsDAOImpl implements StockDetailsDAO{
public boolean updateaddstock(int ProductID, int in_stock) {
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		StockDetails stockdetails = stockdetailsdao.getstockbyproductid(ProductID);
		int stock = stockdetails.getIn_stock();
		stock = stock+in_stock;
		stockdetails.setIn_stock(stock);
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(stockdetails);
			session.getTransaction().commit();
			session.close();
			System.out.println("product stock is add to the table");
		    return true;
		}
		catch(Exception e){
			System.out.println("updateaddstock error"+e);
			return false;
		}
		}


public boolean updateminusstock(int ProductID, int in_stock) {
	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
	StockDetails stockdetails = stockdetailsdao.getstockbyproductid(ProductID);
	int stock = stockdetails.getIn_stock();
	stock = stock-in_stock;
	stockdetails.setIn_stock(stock);
	h2config h2 = new h2config();
	try{
		SessionFactory sessionFactory = h2.getHibernateSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.update(stockdetails);
		session.getTransaction().commit();
		session.close();
		System.out.println("product stock is minus from the table");
	    return true;
	}
	catch(Exception e){
		System.out.println("updateminusstock error"+e);
		return false;
	}
	
}

public StockDetails getstockbyproductid(int ProductID) {
    	 h2config h2 = new h2config();
 		StockDetails stock = null;
 		try{
 			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
 			Session session = sessionFactory.openSession();
 			session.beginTransaction();
 			stock = (StockDetails)session.createQuery("from StockDetails where Product_ProductId='"+ProductID+"'").uniqueResult();
 			session.getTransaction().commit();
 			session.close();
 		}
 		catch(Exception e){
 			System.out.println("getstockbyproductid error"+e);
 		}
 		return stock;
 		
	}

	public boolean addStock(StockDetails stock) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(stock);
			session.getTransaction().commit();
			
			
			System.out.println(" StockDetailsDAOImpl addstock Data stored in stock Table ");
			
			return true;
		}
		catch(Exception e){
			System.out.println("addstock error"+e);
			return false;
		}
		
	}

	public boolean deleteStock(StockDetails stock) {
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(stock);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is deleted from table");
			return true;
		}
		catch(Exception e){
			System.out.println("deletestock error"+e);
			return false;
		}

	}

	public boolean UpdateStock(StockDetails stock) {
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//stock=stockdetailsdao.getstockbyid(0);
			//stock.setProductId(0);
			//stock.setIn_stock(0);
			session.update(stock);
			session.getTransaction().commit();
			session.close();
			System.out.println("data is updated from table");
			return true;
		}
		catch(Exception e){
			System.out.println("updatestock error"+e);
			return false;	
		}
	}

	public List<StockDetails> getallStock() {
		List <StockDetails>list=null;
		h2config h2 = new h2config();
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			list = (List<StockDetails>)session.createQuery("from StockDetails").list();
			System.out.println(list);
			session.getTransaction().commit();
			session.close();
			return list;	
		}
		catch(Exception e){
			System.out.println("StockDetails list error"+e);
			return list;
		}
		
	}

	public StockDetails getstockbyid(int StockId) {
		h2config h2 = new h2config();
		StockDetails stock=null;
		try{
			SessionFactory sessionFactory = h2.getHibernateSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			stock = (StockDetails)session.createQuery("from StockDetails where StockId='"+StockId+"'").uniqueResult();
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println("getstockbyid error"+e);
		}
		return stock;
	}
		
	}


