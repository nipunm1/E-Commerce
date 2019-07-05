package com.niit.frontend.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.CategoryDetailsDAO;
import com.niit.backend.daoimpl.CategoryDetailsDAOImpl;
import com.niit.backend.model.CategoryDetails;

@Controller
public class CategoryController {
	@RequestMapping(value="/addcategory", method=RequestMethod.GET) 
	public String addsupplier(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("add category controller");
		System.out.println("********************************");
		CategoryDetails categorydetails = new CategoryDetails();
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		
		
		String name = req.getParameter("catname");
		
		categorydetails.setCategoryName(name);
		
		
		categorydetailsdao.addCategory(categorydetails);
		
		CategoryDetailsDAO categoryDetailsdao = new CategoryDetailsDAOImpl();
		List<CategoryDetails> categorydetailslist = categoryDetailsdao.getallCategory();
		Iterator item = categorydetailslist.iterator();
		while(item.hasNext()){
			CategoryDetails category = (CategoryDetails) item.next();
			System.out.println(categorydetails.getCategoryId());
			System.out.println(categorydetails.getCategoryName());
		}
		HttpSession session = req.getSession();
		session.setAttribute("list", categorydetailslist);
		return "category";
	}
}
