package com.niit.frontend.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
public class UpdateController {
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String UpdateCategory(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("update category controller");
		System.out.println("********************************");
		
		CategoryDetails categorydetails = new CategoryDetails();
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		
		String str = req.getParameter("category_id");
		int id = Integer.parseInt(str);
		String name = req.getParameter("category_name");
		
		categorydetails=categorydetailsdao.getcategorybyid(id);
		categorydetails.setCategoryName(name);
		
		categorydetailsdao.updateCategory(categorydetails);
		
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
	@RequestMapping(value="/updatesup", method=RequestMethod.GET)
	public String UpdateSupplier(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("update supplier controller");
		System.out.println("********************************");
		
		SupplierDetails supplierdetails = new SupplierDetails();
		SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		
		String str = req.getParameter("supplier_id");
		int id = Integer.parseInt(str);
		String address = req.getParameter("supplier_address");
		String email = req.getParameter("supplier_email");
		String name = req.getParameter("supplier_name");
		String number = req.getParameter("supplier_number");
		
		supplierdetails=supplierdetailsdao.getsupplierbyid(id);
		supplierdetails.setSupplierAddress(address);
		supplierdetails.setSupplierEmail(email);
		supplierdetails.setSupplierName(name);
		supplierdetails.setSupplierNumber(number);
		
		supplierdetailsdao.UpdateSupplier(supplierdetails);
		
		SupplierDetailsDAO supplierDetailsdao = new SupplierDetailsDAOImpl();
		List<SupplierDetails> supplierdetailslist = supplierDetailsdao.getallSupplier();
		Iterator item = supplierdetailslist.iterator();
		while(item.hasNext()){
			SupplierDetails supplier = (SupplierDetails) item.next();
			System.out.println(supplier.getSupplierID());
			System.out.println(supplier.getSupplierAddress());
			System.out.println(supplier.getSupplierEmail());
			System.out.println(supplier.getSupplierName());
			System.out.println(supplier.getSupplierNumber());
		}
		HttpSession session = req.getSession();
		session.setAttribute("list", supplierdetailslist);
		return "supplier";
	}
	@RequestMapping(value="/updatepr", method=RequestMethod.POST)
	public String UpdateProduct(@RequestParam CommonsMultipartFile file,HttpSession session,HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("update product controller");
		System.out.println("********************************");
		
		int idpr=0;
		productDetailsDAO productDetailsdao1 = new productDetailsDAOImpl();
		List<productDetails> productdetailslist1 = productDetailsdao1.getallproduct();
		Iterator item = productdetailslist1.iterator();
		while(item.hasNext()){
			productDetails product = (productDetails) item.next();
			 idpr=product.getProductID();
	     	}
		
		productDetails productdetails = new productDetails();
	    productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
		CategoryDetails categorydetails = new CategoryDetails();
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		SupplierDetails supplierdetails = new SupplierDetails();
		SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		
		
		String cat=req.getParameter("cat_id");
        int catid = Integer.parseInt(cat);
        String sup=req.getParameter("sup_id");
        int supid = Integer.parseInt(sup);
        String str = req.getParameter("product_id");
		int id = Integer.parseInt(str);
		String discription = req.getParameter("product_discription");
		String str1 = req.getParameter("product_price");
		int price = Integer.parseInt(str1);
		String name = req.getParameter("product_name");
		String filename1 = file.getOriginalFilename();
		String filename="";
		int img=0;
		if(filename1.length()!=0)
		{
		 String filenames[] = filename1.split("\\.");
	     filename = filenames[0]+id+"."+filenames[1];
	     try{  
	        byte barr[]=file.getBytes();  
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream("E:/image"+"/"+filename));  
	        bout.write(barr);  
	        bout.flush();  
	        bout.close(); 
	        img=100;
	       
	        }
	     catch(Exception e){
	        System.out.println("error in finding path"+e);
	        }
		}
		
		productdetails = productdetailsdao.getproductbyid(id);
		categorydetails.setCategoryId(catid);
		supplierdetails.setSupplierID(supid);
		productdetails.setCategory(categorydetails);
		productdetails.setSupplier(supplierdetails);
		productdetails.setProductDiscription(discription);
		productdetails.setProductName(name);
		if(img==100)
		{
		 productdetails.setProductImage(filename);
		}
		
		productdetails.setProductPrice(price);
		
		productdetailsdao.UpdateProduct(productdetails);
		
		productDetailsDAO productDetailsdao = new productDetailsDAOImpl();
		List<productDetails> productdetailslist = productDetailsdao.getallproduct();
		HttpSession session1 = req.getSession();
		session1.setAttribute("list", productdetailslist);
	
		return "product";
	}
	@RequestMapping(value="/updatest", method=RequestMethod.GET)
	public String UpdateStock(HttpServletRequest req){
		System.out.println("********************************");
		System.out.println("update stock controller");
		System.out.println("********************************");
		
		StockDetails stockdetails = new StockDetails();
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		productDetails productdetails = new productDetails();
		productDetailsDAO productdetailsdao = new productDetailsDAOImpl();
		
		String st = req.getParameter("pr_id");
		int prid = Integer.parseInt(st);
		String str = req.getParameter("stock_id");
		int stid = Integer.parseInt(str);
		String str1 = req.getParameter("in_stock");
		int instock = Integer.parseInt(str1);
		
		stockdetails = stockdetailsdao.getstockbyid(stid);
		productdetails.setProductID(prid);
		stockdetails.setProduct(productdetails);
		stockdetails.setIn_stock(instock);
		
		stockdetailsdao.UpdateStock(stockdetails);
		
		StockDetailsDAO stockDetailsdao = new StockDetailsDAOImpl();
		List<StockDetails>stockdetailslist = stockDetailsdao.getallStock();
		HttpSession session = req.getSession();
		session.setAttribute("stock_list",stockdetailslist);
		
		return "stock";
	}
}
