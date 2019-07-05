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
public class DeleteController {
@RequestMapping(value="/delcat", method=RequestMethod.GET)	
public String deleteCategory(HttpServletRequest req){
	System.out.println("********************************");
	System.out.println("delete category controller");
	System.out.println("********************************");
	CategoryDetails categorydetails = new CategoryDetails();
	CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
	String str = req.getParameter("CategoryId");
	int id = Integer.parseInt(str); 
    
    System.out.println(id);
	categorydetails.setCategoryId(id);
	
	categorydetailsdao.deleteCategory(categorydetails);
	
	CategoryDetailsDAO categorydao = new CategoryDetailsDAOImpl();
	List<CategoryDetails> list = categorydao.getallCategory();
	HttpSession session = req.getSession();
	session.setAttribute("list", list);
	return "category";
}
@RequestMapping(value="/delsup", method=RequestMethod.GET)
public String deleteSupplier(HttpServletRequest req){
	System.out.println("********************************");
	System.out.println("delete supplier controller");
	System.out.println("********************************");
	SupplierDetails supplierdetails = new SupplierDetails();
	SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
	String str = req.getParameter("SupplierID");
	int id = Integer.parseInt(str); 
    
    System.out.println(id);
	supplierdetails.setSupplierID(id);
	
	supplierdetailsdao.deleteSupplier(supplierdetails);
	
	SupplierDetailsDAO supplierdao = new SupplierDetailsDAOImpl();
	List<SupplierDetails> list = supplierdao.getallSupplier();
	HttpSession session = req.getSession();
	session.setAttribute("list", list);
	return "supplier";
}
@RequestMapping(value="/delpr", method=RequestMethod.GET)
public String deleteProduct(HttpServletRequest req){
	System.out.println("********************************");
	System.out.println("delete product controller");
	System.out.println("********************************");
	productDetails productdetails = new productDetails();
	productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
	String str = req.getParameter("ProductID");
	int id = Integer.parseInt(str); 
    
    
	productdetails.setProductID(id);
	
	productdetailsdao.deleteProduct(productdetails);
	
	productDetailsDAO productdao = new productDetailsDAOImpl();
	List<productDetails> list = productdao.getallproduct();
	HttpSession session = req.getSession();
	session.setAttribute("list", list);

	return "product"; 
}
@RequestMapping(value="/remove", method=RequestMethod.GET)
public String removecart(HttpServletRequest req){
	System.out.println("********************************");
	System.out.println("remove cart controller");
	System.out.println("********************************");
	CartDetails cartdetails = new CartDetails();
	CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
	productDetails productdetails = new productDetails();
	
	String str = req.getParameter("CartId");
	int cart_id = Integer.parseInt(str);
	String str1 = req.getParameter("qty");
	int qty = Integer.parseInt(str1);
	String str2 = req.getParameter("ProductID");
	int id = Integer.parseInt(str2);
	System.out.println(qty);
	System.out.println(id);
	
	cartdetails.setCartId(cart_id);
	cartdetails.setCartQuantity(qty);
	productdetails.setProductID(id);
	cartdetails.setProduct(productdetails);
	
	cartdetailsdao.deleteCart(cartdetails);
	
	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
	boolean b=stockdetailsdao.updateaddstock(id, qty);
	
	
	
	CartDetailsDAO cartdao = new CartDetailsDAOImpl();
	List<CartDetails> list = cartdao.getallCart();
	HttpSession session1 = req.getSession();
	session1.setAttribute("cartlist", list);
	if(b==true){
		return "cart";
	}
	else{
		return"error";
	}
}
@RequestMapping(value="/delst", method=RequestMethod.GET)
public String deletestock(HttpServletRequest req){
	System.out.println("********************************");
	System.out.println("delete stock controller");
	System.out.println("********************************");
	StockDetails stockdetails = new StockDetails();
	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
	
	String str = req.getParameter("StockID");
	int id = Integer.parseInt(str);
	
	stockdetails.setStockId(id);
	
	stockdetailsdao.deleteStock(stockdetails);
	
	StockDetailsDAO stockDetailsdao = new StockDetailsDAOImpl();
	List<StockDetails> stocklist = stockDetailsdao.getallStock();
	HttpSession session = req.getSession();
	session.setAttribute("stock_list", stocklist);
	
	return "stock";
}
}
