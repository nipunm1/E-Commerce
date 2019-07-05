package com.niit.frontend.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

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
public class ProductController {
	@RequestMapping(value="/addproduct", method=RequestMethod.POST)
	public ModelAndView addproduct(@RequestParam CommonsMultipartFile file,HttpSession session,HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("add product controller");
		System.out.println("********************************");
		int id=0;
		productDetailsDAO productDetailsdao1 = new productDetailsDAOImpl();
		List<productDetails> productdetailslist1 = productDetailsdao1.getallproduct();
		Iterator item = productdetailslist1.iterator();
		while(item.hasNext()){
			productDetails product = (productDetails) item.next();
			 id=product.getProductID();
	     	}
		productDetails productdetails = new productDetails();
		productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
		CategoryDetails categorydetails = new CategoryDetails();
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		SupplierDetails supplierdetails = new SupplierDetails();
		SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		
		String str1=req.getParameter("categoryid");
		int categoryid=Integer.parseInt(str1);
		String str2=req.getParameter("supplierid");
		int supplierid=Integer.parseInt(str2);
		String name = req.getParameter("prname");
		String desc = req.getParameter("desc");
		String str = req.getParameter("price");
		int price = Integer.parseInt(str);
		String filename1 = file.getOriginalFilename();
       String filenames[] = filename1.split("\\.");
        String filename = filenames[0]+id+"."+filenames[1];
        try{  
        byte barr[]=file.getBytes();  
        BufferedOutputStream bout=new BufferedOutputStream(  
                 new FileOutputStream("E:/image"+"/"+filename));  
        bout.write(barr);  
        bout.flush();  
        bout.close();  
        }
        catch(Exception e){
        System.out.println("error in finding path"+e);
        }
        
        categorydetails.setCategoryId(categoryid);
        supplierdetails.setSupplierID(supplierid);
        productdetails.setCategory(categorydetails);
        productdetails.setSupplier(supplierdetails);
		productdetails.setProductName(name);
		productdetails.setProductDiscription(desc);
        productdetails.setProductPrice(price);
		productdetails.setProductImage(filename);
		
		productdetailsdao.addProduct(productdetails);
		
		productDetailsDAO productDetailsdao = new productDetailsDAOImpl();
		List<productDetails> productdetailslist = productDetailsdao.getallproduct();
		
		HttpSession session1 = req.getSession();
		session1.setAttribute("list", productdetailslist);
		
        List<CategoryDetails> categorydetailslist=categorydetailsdao.getallCategory();
	    
	    HttpSession session2 = req.getSession();
	    session2.setAttribute("list1", categorydetailslist);
	    
	    
	    List<SupplierDetails> supplierdetailslist = supplierdetailsdao.getallSupplier();
	    
	    HttpSession session3 = req.getSession();
	    session3.setAttribute("list2", supplierdetailslist);
	    
	    

		 return new ModelAndView("product");
	}
	
	
}
