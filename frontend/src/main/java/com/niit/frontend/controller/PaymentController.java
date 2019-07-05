package com.niit.frontend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PaymentController {
	@RequestMapping(value="/checkout",method=RequestMethod.GET)
public String checkout(HttpServletRequest req,HttpServletResponse res){
		System.out.println("*******************************");
		System.out.println("checkout controller");
		System.out.println("********************************");
		
	return "payment";
}
	@RequestMapping(value="/addpayment",method=RequestMethod.GET)
public String finish(HttpServletRequest req,HttpServletResponse res){
		System.out.println("********************************");
		System.out.println("Payment controller");
		System.out.println("********************************");
		
	return "finish";
}
}
