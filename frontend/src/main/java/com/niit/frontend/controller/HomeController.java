package com.niit.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.CartDetailsDAO;
import com.niit.backend.dao.CategoryDetailsDAO;
import com.niit.backend.dao.StockDetailsDAO;
import com.niit.backend.dao.SupplierDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.daoimpl.CartDetailsDAOImpl;
import com.niit.backend.daoimpl.CategoryDetailsDAOImpl;
import com.niit.backend.daoimpl.StockDetailsDAOImpl;
import com.niit.backend.daoimpl.SupplierDetailsDAOImpl;
import com.niit.backend.daoimpl.productDetailsDAOImpl;
import com.niit.backend.model.CartDetails;
import com.niit.backend.model.CategoryDetails;
import com.niit.backend.model.StockDetails;
import com.niit.backend.model.SupplierDetails;
import com.niit.backend.model.productDetails;  
	  
	@Controller  
	public class HomeController 
	{  
		@RequestMapping(value="/home", method=RequestMethod.GET)
		public String home(HttpServletRequest req){
			System.out.println("*******************************");
	    	System.out.println("Home controller");
	    	System.out.println("*******************************");
	    	productDetailsDAO productdao = new productDetailsDAOImpl();
			List<productDetails> list = productdao.getallproduct();
			HttpSession session = req.getSession();
			session.setAttribute("listpr", list);
			
			StockDetailsDAO stockdao = new StockDetailsDAOImpl();
			List<StockDetails>list1 = stockdao.getallStock();
			HttpSession session1 = req.getSession();
			session1.setAttribute("stock_list", list1);
			
			return "home";
		}
		
	    @RequestMapping(value="/", method=RequestMethod.GET)  
	    public String Start(HttpServletRequest req)
	    {  try{
	    	
	    	
	    	System.out.println("*******************************");
	    	System.out.println("Start controller");
	    	System.out.println("*******************************");
	    	productDetailsDAO productdao = new productDetailsDAOImpl();
			List<productDetails> list = productdao.getallproduct();
			HttpSession session = req.getSession();
			session.setAttribute("listpr", list);
			
			StockDetailsDAO stockdao = new StockDetailsDAOImpl();
			List<StockDetails>list1 = stockdao.getallStock();
			HttpSession session1 = req.getSession();
			session1.setAttribute("stock_list", list1);
	    }
	    catch(Exception e){
	    	System.out.println("start controller error"+e);
	    }
			return "home";  
	    }  
	@RequestMapping(value="/register", method=RequestMethod.GET)  
	    public String register(){
	    		 System.out.println("*******************************");
	    	    	System.out.println("register controller");
	    	    	System.out.println("*******************************");
	    	return "register";
	    	
	    	
	    }
	    @RequestMapping(value="/loginadd",method=RequestMethod.GET)
	    public String login(){
	    	System.out.println("*******************************");
	    	System.out.println("loginadd controller");
	    	System.out.println("*******************************");
	    	return "login";
	    }
	    
	    @RequestMapping(value="/supplier", method=RequestMethod.GET)
		 public String supplier(HttpServletRequest req){
			 System.out.println("*******************************");
		    	System.out.println("supplier controller");
		    	System.out.println("*******************************");
		    	
		    	SupplierDetailsDAO supplierdao = new SupplierDetailsDAOImpl();
				List<SupplierDetails> list = supplierdao.getallSupplier();
				HttpSession session = req.getSession();
				session.setAttribute("list", list);
		    	
			 return "supplier";
		 }
	    @RequestMapping(value="/category", method=RequestMethod.GET)
		public String category(HttpServletRequest req){
			System.out.println("********************************");
			System.out.println("category controller");
			System.out.println("********************************");
			
			CategoryDetailsDAO categorydao = new CategoryDetailsDAOImpl();
			List<CategoryDetails> list = categorydao.getallCategory();
			HttpSession session = req.getSession();
			session.setAttribute("list", list);
			
			return "category";
		}
	    @RequestMapping(value="/product", method=RequestMethod.GET)
		 public String product(HttpServletRequest req){
			 System.out.println("*******************************");
		    	System.out.println("product controller");
		    	System.out.println("*******************************");
		    	productDetailsDAO productdao = new productDetailsDAOImpl();
				List<productDetails> list = productdao.getallproduct();
				HttpSession session = req.getSession();
				
				session.setAttribute("list", list);
				
				CategoryDetailsDAO categorydao = new CategoryDetailsDAOImpl();
				List<CategoryDetails> list1 = categorydao.getallCategory(); 
				HttpSession session1 = req.getSession();
				session1.setAttribute("list1", list1);
				
				SupplierDetailsDAO supplierdao = new SupplierDetailsDAOImpl();
				List<SupplierDetails> list2 = supplierdao.getallSupplier(); 
				HttpSession session2 = req.getSession();
				session2.setAttribute("list2", list2);
				
				StockDetailsDAO stockdao = new StockDetailsDAOImpl();
				List<StockDetails> list3 = stockdao.getallStock();
                HttpSession session3 = req.getSession();
                session3.setAttribute("list3", list3);
				
		        return "product";
		 }
	    @RequestMapping(value="/cart", method=RequestMethod.GET)
	    public String cart(HttpServletRequest req){
	    	System.out.println("*******************************");
	    	System.out.println("cart controller");
	    	System.out.println("*******************************");
	    CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
	    List<CartDetails> list = cartdetailsdao.getallCart();
	    HttpSession session = req.getSession();
	    session.setAttribute("cartlist", list);
	    
	    	return "cart";
	    }
	    @RequestMapping(value="/stock", method=RequestMethod.GET)
	    public String Stock(HttpServletRequest req){
	    	System.out.println("*******************************");
	    	System.out.println("stock controller");
	    	System.out.println("*******************************");
	    	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
	    	List<StockDetails> list = stockdetailsdao.getallStock();
	    	HttpSession session = req.getSession();
		    session.setAttribute("stock_list", list);
		    
		    productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
		    List<productDetails> list1 = productdetailsdao.getallproduct();
		    HttpSession session1 = req.getSession();
		    session1.setAttribute("product_list", list1);
		    
		   return "stock";
	    }
}
