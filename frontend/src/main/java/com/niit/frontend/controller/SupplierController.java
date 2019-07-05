package com.niit.frontend.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.niit.backend.dao.SupplierDetailsDAO;
import com.niit.backend.daoimpl.SupplierDetailsDAOImpl;
import com.niit.backend.model.SupplierDetails;

@Controller
public class SupplierController {
	@RequestMapping(value="/addsupplier", method=RequestMethod.GET)  
    public String addsupplier(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("add supplier controller");
		System.out.println("********************************");
		SupplierDetails supplierdetails = new SupplierDetails();
		SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		
		String name = req.getParameter("supname");
		String email = req.getParameter("supemail");
	    String address = req.getParameter("supaddress");
	    String number = req.getParameter("supnumber");
	    supplierdetails.setSupplierName(name);
		supplierdetails.setSupplierEmail(email);
		supplierdetails.setSupplierAddress(address);
		supplierdetails.setSupplierNumber(number);
		supplierdetailsdao.addSupplier(supplierdetails);
		
		SupplierDetailsDAO supplierDetailsdao = new SupplierDetailsDAOImpl();
		List<SupplierDetails> supplierdetailslist = supplierDetailsdao.getallSupplier();
		Iterator item = supplierdetailslist.iterator();
		while(item.hasNext()){
			SupplierDetails supplier = (SupplierDetails) item.next();
			System.out.println(supplierdetails.getSupplierID());
			System.out.println(supplierdetails.getSupplierAddress());
			System.out.println(supplierdetails.getSupplierEmail());
			System.out.println(supplierdetails.getSupplierName());
			System.out.println(supplierdetails.getSupplierNumber());
		}
		HttpSession session = req.getSession();
		session.setAttribute("list", supplierdetailslist);
		return "supplier";
	}
}
