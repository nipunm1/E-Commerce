package com.niit.backend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.SupplierDetailsDAO;
import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.daoimpl.SupplierDetailsDAOImpl;
import com.niit.backend.daoimpl.UserDetailsDAOImpl;
import com.niit.backend.model.SupplierDetails;
import com.niit.backend.model.UserDetails;

public class SupplierDetailsDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
    @Ignore
	@Test
	public void test() {
		fail("Not yet implemented");
	}
    @Ignore
    @Test
    public void addsuppliertest(){
    	System.out.println("addsupplier begins");
    	SupplierDetails supplierdetails = new SupplierDetails();
    	SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
    	supplierdetails.setSupplierAddress("pitampura");
    	supplierdetails.setSupplierNumber("9999554813");
    	supplierdetails.setSupplierEmail("xyz@niit.com");
    	supplierdetails.setSupplierName("aayush");
        
    	boolean flag = supplierdetailsdao.addSupplier(supplierdetails);
    	assertTrue( flag );
    	
    }
    @Ignore
    @Test
    public void getallsuppliertest(){
    	System.out.println("getallsupplier begins");
    	SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		List<SupplierDetails> list =supplierdetailsdao.getallSupplier();
		boolean flag = false;
		if(list!=null)
		{
			flag=true;
			   
			Iterator item = list.iterator();
			while(item.hasNext()){
				SupplierDetails supplier=(SupplierDetails) item.next();
				System.out.println("supplier id = "+supplier.getSupplierID());
				System.out.println("supplier name = "+supplier.getSupplierName());
			    System.out.println("supplier number = "+supplier.getSupplierNumber());
			    System.out.println("supplier email = "+supplier.getSupplierEmail());
			    System.out.println("supplier address = "+supplier.getSupplierAddress());
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
    public void getsupplierbyidtest(){
    System.out.println("getsupplierbyidtest begins");
    SupplierDetails supplierdetails = new SupplierDetails();
    SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
    supplierdetails = supplierdetailsdao.getsupplierbyid(02);
    boolean flag = false;
	if(supplierdetails!=null){
		System.out.println("supplier id  =  "+supplierdetails.getSupplierID()); 
		System.out.println("supplier name  =  "+supplierdetails.getSupplierName());
		System.out.println("supplier number = "+supplierdetails.getSupplierNumber());
	    System.out.println("supplier email = "+supplierdetails.getSupplierEmail());
	    System.out.println("supplier address = "+supplierdetails.getSupplierAddress());
		flag=true;
	}
	else{
      flag=false;
	}
	
	assertTrue( flag );
    }
    @Ignore
    @Test
    public void deletesuppliertest(){
    	System.out.println("deletesuppliertest begins");
    	boolean flag=false;
    	SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		SupplierDetails supplierdetails = new SupplierDetails();
		supplierdetails.setSupplierID(02);
		flag=supplierdetailsdao.deleteSupplier(supplierdetails);
		assertTrue( flag );
    }
    @Ignore
    @Test
    public void updatesuppliertest(){
    	boolean flag=false;
    	System.out.println("updatesuppliertest begins");
    	SupplierDetailsDAO supplierdetailsdao = new SupplierDetailsDAOImpl();
		SupplierDetails supplierdetails = new SupplierDetails();
		flag=supplierdetailsdao.UpdateSupplier(supplierdetails);
		assertTrue( flag );
    }
}