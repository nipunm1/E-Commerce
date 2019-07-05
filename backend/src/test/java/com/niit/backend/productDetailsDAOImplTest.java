package com.niit.backend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.daoimpl.UserDetailsDAOImpl;
import com.niit.backend.daoimpl.productDetailsDAOImpl;
import com.niit.backend.model.CategoryDetails;
import com.niit.backend.model.SupplierDetails;
import com.niit.backend.model.UserDetails;
import com.niit.backend.model.productDetails;

public class productDetailsDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(" ");
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
    public void addproducttest(){
		boolean flag=false;
	System.out.println("addProduct Begin ");
	CategoryDetails categorydetails = new CategoryDetails();
	SupplierDetails supplierdetails = new SupplierDetails();
	categorydetails.setCategoryId(04);
	supplierdetails.setSupplierID(04);
		productDetails productDetails = new productDetails();
		productDetails.setSupplier(supplierdetails);
		productDetails.setCategory(categorydetails);
		productDetails.setProductDiscription("chocolate");
		//productDetails.setProductImage("");
		productDetails.setProductName("milkybar");
		productDetails.setProductPrice(30);
		
		
		productDetailsDAO productDetailsDAO = new productDetailsDAOImpl();
		 flag=productDetailsDAO.addProduct(productDetails);
		
		assertTrue( flag );
    }
    @Ignore
	@Test
	public void deleteproducttest(){
		boolean flag=false;
		System.out.println("delete product begins");
		productDetailsDAO Productdetailsdao = new productDetailsDAOImpl();
		productDetails ProductDetails = new productDetails();
		ProductDetails.setProductID(01);
		flag=Productdetailsdao.deleteProduct(ProductDetails);
		assertTrue( flag );
	}
	@Ignore
	@Test
	public void updateproducttest(){
		boolean flag=false;
		System.out.println("update user begins");
		productDetailsDAO Productdetailsdao = new productDetailsDAOImpl();
		productDetails ProductDetails = new productDetails();
		flag=Productdetailsdao.UpdateProduct(ProductDetails);
		assertTrue( flag );
	}
	@Ignore
    @Test
    public void getproductbyid(){
    	System.out.println("getproductbyid begins");
		productDetailsDAO Productdetailsdao = new productDetailsDAOImpl();
		productDetails ProductDetails = new productDetails();
		ProductDetails=Productdetailsdao.getproductbyid(02);
		boolean flag = false;
		if(ProductDetails!=null){
			System.out.println("product id  =  "+ProductDetails.getProductID());
			System.out.println("product discription  =  "+ProductDetails.getProductDiscription());
			System.out.println("product image  =  "+ProductDetails.getProductImage());
			System.out.println("product name  =  "+ProductDetails.getProductName());
			System.out.println("product price  =  "+ProductDetails.getProductPrice());
     		flag=true;
		}
		else{
          flag=false;
		}
		
		assertTrue( flag );
	}
	@Ignore
    @Test
    public void getallproduct(){
System.out.println("getallproduct begin");
		
		productDetailsDAO Productdetailsdao = new productDetailsDAOImpl();
		List<productDetails> list =Productdetailsdao.getallproduct();
		
		boolean flag = false;
		if(list!=null)
		{
			flag=true;
			   
			Iterator item = list.iterator();
			while(item.hasNext()){
				productDetails p=(productDetails) item.next();
				System.out.println("prduct id"+ p.getProductID());
				System.out.println("prduct name"+ p.getProductName());
				System.out.println("product discription"+ p.getProductDiscription());
				System.out.println("product image"+ p.getProductImage());
				System.out.println("product price"+ p.getProductPrice());
				
				
			
			}
		}
		else
		{
			flag=false;
		}
		assertTrue( flag );
	}	
    }

