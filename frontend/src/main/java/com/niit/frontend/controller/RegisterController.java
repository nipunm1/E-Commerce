package com.niit.frontend.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.daoimpl.UserDetailsDAOImpl;
import com.niit.backend.model.UserDetails;

@Controller
public class RegisterController {
	
	
	
	@RequestMapping(value="/addregister", method=RequestMethod.GET)  
    public String addregister(HttpServletRequest req)
	{
    		    System.out.println("*******************************");
    	    	System.out.println("Add register controller");
    	    	System.out.println("*******************************");
    	    	UserDetailsDAO userdetailsdao=new UserDetailsDAOImpl();
    	    	UserDetails user = new UserDetails();	
    	     
    	    	String email = req.getParameter("email");
    	    	String pwd = req.getParameter("pwd");
    	    	String username = req.getParameter("username");
    	    	String address = req.getParameter("address");
    	    	String mobile = req.getParameter("mobile");
    	    	String aadharid=req.getParameter("aadharid");
    	    	
    	    	user.setUserEmail(email);
    	    	user.setUserAddress(address);
    	    	user.setUserMobile(mobile);
    	    	user.setUserName(username);
    	    	user.setUserPassword(pwd);
    	    	user.setUserAadharId(aadharid);
    	    	
    	  
    	    	userdetailsdao.addUser(user);
    	return "register";
    	
    	
    }
	 
}
