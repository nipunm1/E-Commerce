package com.niit.backend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.CategoryDetailsDAO;
import com.niit.backend.dao.PaymentDetailsDAO;
import com.niit.backend.daoimpl.CategoryDetailsDAOImpl;
import com.niit.backend.daoimpl.PaymentDetailsDAOImpl;
import com.niit.backend.model.CategoryDetails;
import com.niit.backend.model.PaymentDetails;
import com.niit.backend.model.UserDetails;

public class CategoryDetailsDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("");
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void addCategoryTest(){
		boolean flag=false;
		System.out.println("addcategory Begin ");
		
				CategoryDetails categoryDetails = new CategoryDetails();
				categoryDetails.setCategoryName("Electronics");
			
				CategoryDetailsDAO categoryDetailsDAO = new CategoryDetailsDAOImpl();
				 flag=categoryDetailsDAO.addCategory(categoryDetails);
				
				assertTrue( flag );
	
	}
    @Ignore
	@Test
	public void getallcategorytest(){
		System.out.println("getallcategory begin");
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		List<CategoryDetails> list = categorydetailsdao.getallCategory();
		
		boolean flag = false;
		if(list!=null)
		{
			
			   
			Iterator item = list.iterator();
			while(item.hasNext()){
				CategoryDetails c=(CategoryDetails) item.next();
				System.out.println("category id  =   "+c.getCategoryId());
				System.out.println("category name  =  "+c.getCategoryName());
				flag=true;
			}
		}
		else
		{
			flag=false;
		}
		assertTrue( flag );
	}
	@Ignore
	@Test
	public void getcategorybyidtest(){
		System.out.println("getcategorybyid begins");
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails=categorydetailsdao.getcategorybyid(02);
		boolean flag = false;
		if(categoryDetails!=null){
			System.out.println("category id = "+ categoryDetails.getCategoryId());
			System.out.println("category name = "+ categoryDetails.getCategoryName());
     		flag=true;
		}
		else{
          flag=false;
		}
		
		assertTrue( flag );

	}
	@Ignore
	@Test
	public void deletecategorytest(){
		boolean flag=false;
		System.out.println("delete category begins");
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		CategoryDetails categoryDetails = new CategoryDetails();
		categoryDetails.setCategoryId(35);
		flag=categorydetailsdao.deleteCategory(categoryDetails);
		assertTrue( flag );
	}
	@Ignore
	@Test
	public void updatecategorytest(){
		boolean flag=false;
		System.out.println("update category begins");
		CategoryDetailsDAO categorydetailsdao = new CategoryDetailsDAOImpl();
		CategoryDetails categoryDetails = new CategoryDetails();
		flag=categorydetailsdao.updateCategory(categoryDetails);
		assertTrue( flag );
	}
}
