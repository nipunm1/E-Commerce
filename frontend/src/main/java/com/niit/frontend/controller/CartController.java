package com.niit.frontend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.CartDetailsDAO;
import com.niit.backend.dao.StockDetailsDAO;
import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.daoimpl.CartDetailsDAOImpl;
import com.niit.backend.daoimpl.StockDetailsDAOImpl;
import com.niit.backend.daoimpl.UserDetailsDAOImpl;
import com.niit.backend.daoimpl.productDetailsDAOImpl;
import com.niit.backend.model.CartDetails;
import com.niit.backend.model.StockDetails;
import com.niit.backend.model.UserDetails;
import com.niit.backend.model.productDetails;

@Controller
public class CartController {

	 @RequestMapping(value="/test", method=RequestMethod.GET)  
	    public String test(HttpServletRequest req)
	    {
		 	String qty = req.getParameter("qty");
		  String total = req.getParameter("total");
		 HttpSession sess = req.getSession();
		  sess.setAttribute("qty", qty);
          sess.setAttribute("total", total);
		 return "home";
	    }
	
	@RequestMapping(value="/addtocart",method=RequestMethod.GET)
	public String addtocart(HttpServletRequest req,HttpServletResponse res){
		System.out.println("********************************");
		System.out.println("add to cart controller");
		System.out.println("********************************");
	productDetails productdetails = new productDetails();	
	UserDetails userdetails = new UserDetails();
	CartDetails cartdetails = new CartDetails();
	CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
	
	HttpSession session = req.getSession();
	String str1 = (String)session.getAttribute("qty");
	int qty = Integer.parseInt(str1);
	String str2 = (String)session.getAttribute("total");
    int total = Integer.parseInt(str2);
	
	String email = req.getParameter("UserEmail");
	String str = req.getParameter("ProductID");
	int id = Integer.parseInt(str);
	String itemname=req.getParameter("itemnames");
	
    System.out.println("Email = "+email);
	System.out.println("Product id = "+id);
	System.out.println("Product name = "+itemname);
	System.out.println("Product quantity = "+qty);
	System.out.println("Product total = "+total);
	
	
	productdetails.setProductID(id);
	userdetails.setUserEmail(email);
	cartdetails.setProduct(productdetails);
	cartdetails.setUser(userdetails);
	cartdetails.setCartQuantity(qty);
	cartdetails.setCartTotalAmount(total);
	cartdetails.setCartdateandtime(new Date());
	cartdetails.setCartItems(itemname);
	
	cartdetailsdao.addCart(cartdetails);
	
	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
	boolean b= stockdetailsdao.updateminusstock(id, qty);
	if(b==true){
		return "home";
	}
	else{
		return "error";
	}
	}
	@RequestMapping(value="/contineshopping",method=RequestMethod.GET)
	public String continueshopping(HttpServletRequest req,HttpServletResponse res){
		System.out.println("********************************");
		System.out.println("contine shopping controller");
		System.out.println("********************************");
		return "home";
	}
}
