package com.niit.frontend.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.daoimpl.UserDetailsDAOImpl;
import com.niit.backend.model.UserDetails;

@Controller
public class LoginController  {
	@RequestMapping(value="/loginvalidate",method=RequestMethod.GET)
public String loginvalidate(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException{
		
		UserDetailsDAO userdetailsdao = new UserDetailsDAOImpl();
		String email = req.getParameter("email");
    	String pwd = req.getParameter("pwd");
    	
    	System.out.println(email+ " " +pwd);
    	UserDetails user = userdetailsdao.getuserbyemail(email);
    	
    	String userRole = user.getUserRole();
    	String username = user.getUserName();
    		if(user.getUserEmail().equals(email)&& user.getUserPassword().equals(pwd)){
    			System.out.println(" This is valid user ");
    			
    			HttpSession session=req.getSession();
    			session.setAttribute("useremail", email);
    			session.setAttribute("userRole", userRole);
    			session.setAttribute("username", username);
    		}
    		else{
    			 System.out.println(" This is not a  valid user ");
    			 
    			 
    		}
    	
    	return "home";
	}
	
	@RequestMapping(value="/logout11",method=RequestMethod.GET)
	public String logoutfunction(HttpServletRequest req,HttpServletResponse res){
		 
         HttpSession session=req.getSession();  
         session.setAttribute("useremail", null); 
           
         System.out.print("You are successfully logged out!");  
          
		return "home";
	}
	
	}
