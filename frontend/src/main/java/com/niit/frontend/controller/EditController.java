package com.niit.frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.CategoryDetailsDAO;
import com.niit.backend.dao.StockDetailsDAO;
import com.niit.backend.dao.SupplierDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.daoimpl.CategoryDetailsDAOImpl;
import com.niit.backend.daoimpl.StockDetailsDAOImpl;
import com.niit.backend.daoimpl.SupplierDetailsDAOImpl;
import com.niit.backend.daoimpl.productDetailsDAOImpl;
import com.niit.backend.model.CategoryDetails;
import com.niit.backend.model.StockDetails;
import com.niit.backend.model.SupplierDetails;
import com.niit.backend.model.productDetails;

@Controller
public class EditController {
	@RequestMapping(value="/editCat", method=RequestMethod.GET)
public String editCategory(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("edit category controller");
		System.out.println("********************************");
		
		CategoryDetails categorydetails = new CategoryDetails();
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		
		String str = req.getParameter("CategoryId");
		int id = Integer.parseInt(str);
		
		CategoryDetails catbyid = categorydetailsdao.getcategorybyid(id);
		HttpSession session = req.getSession();
		session.setAttribute("catbyid", catbyid);
		System.out.println("update button poped up");
	    return "category";
}
	@RequestMapping(value="/editsup", method=RequestMethod.GET)
public String editSupplier(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("edit supplier controller");
		System.out.println("********************************");
		
		SupplierDetails supplierdetails = new SupplierDetails();
		SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		
		String str = req.getParameter("SupplierID");
		int id = Integer.parseInt(str);
		
		SupplierDetails supbyid = supplierdetailsdao.getsupplierbyid(id);
		HttpSession session = req.getSession();
		session.setAttribute("supbyid", supbyid);
		System.out.println("update button poped up");
	    return "supplier";
}
	@RequestMapping(value="/editpr", method=RequestMethod.GET)
public String editProduct(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("edit product controller");
		System.out.println("********************************");
		
		productDetails productdetails = new productDetails();
		productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
		
		String str = req.getParameter("ProductID");
		int id = Integer.parseInt(str);
		
		productDetails prbyid = productdetailsdao.getproductbyid(id);
		HttpSession session = req.getSession();
		session.setAttribute("prbyid", prbyid);
		System.out.println("update button poped up");
		return"product";
	}
	@RequestMapping(value="/editst", method=RequestMethod.GET)
public String editstock(HttpServletRequest req){
	System.out.println("********************************");
	System.out.println("edit stock controller");
	System.out.println("********************************");
	
	StockDetails stockdetails = new StockDetails();
	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
	
	String str = req.getParameter("StockID");
	int id = Integer.parseInt(str);
	
	StockDetails stbyid = stockdetailsdao.getstockbyid(id);
	HttpSession session=req.getSession();
	session.setAttribute("stbyid", stbyid);
	System.out.println("update button poped up");
	return"stock";
}
}
