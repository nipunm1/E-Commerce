package com.niit.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.StockDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.daoimpl.StockDetailsDAOImpl;
import com.niit.backend.daoimpl.productDetailsDAOImpl;
import com.niit.backend.model.StockDetails;
import com.niit.backend.model.productDetails;

@Controller
public class StockController {
	@RequestMapping(value="/addstock", method=RequestMethod.GET)
	public String addStock(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("add stock controller");
		System.out.println("********************************");
		
		StockDetails stockdetails = new StockDetails();
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		productDetails productdetails = new productDetails();
		productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
		
		String str1=req.getParameter("productid");
		int productid = Integer.parseInt(str1);
		String str = req.getParameter("instock");
		int stockin = Integer.parseInt(str);
		
		productdetails.setProductID(productid);
		stockdetails.setProduct(productdetails);
		stockdetails.setIn_stock(stockin);
		
		StockDetailsDAO stockdetailsDao = new StockDetailsDAOImpl();
	    StockDetails stock = stockdetailsDao.getstockbyproductid(productid);
	    HttpSession session1 = req.getSession();
	    if(stock!=null){
	    	session1.setAttribute("stocknull",stock);
	    	return "stock";
	    }
		stockdetailsdao.addStock(stockdetails);
		
		session1.setAttribute("stocknull",null);
    	
		
		StockDetailsDAO stockDetailsdao = new StockDetailsDAOImpl();
		List<StockDetails>stockdetailslist = stockDetailsdao.getallStock();
		
		HttpSession session3=req.getSession();
		session3.setAttribute("stock_qty",stockin);
		
		HttpSession session = req.getSession();
		session.setAttribute("stock_list",stockdetailslist );
		
		List<productDetails>productdetailslist = productdetailsdao.getallproduct();
		
		HttpSession session2 = req.getSession();
		session2.setAttribute("product_list", productdetailslist);
		return"stock";
	}
}
