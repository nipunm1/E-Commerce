package com.niit.backend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.PaymentDetailsDAO;
import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.daoimpl.PaymentDetailsDAOImpl;
import com.niit.backend.daoimpl.UserDetailsDAOImpl;
import com.niit.backend.daoimpl.productDetailsDAOImpl;
import com.niit.backend.model.PaymentDetails;
import com.niit.backend.model.UserDetails;
import com.niit.backend.model.productDetails;

public class PaymentDetailsDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("");
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void addPaymentTest(){
		boolean flag=false;
System.out.println("addpayment Begin ");
UserDetails userdetails = new UserDetails();
userdetails.setUserEmail("niit@niit.com");
PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setPaymentType("cash on Delivery");
		paymentDetails.setRecieversAddress("pitampura");
		paymentDetails.setRecieversEmail("niit@niit.com");
		paymentDetails.setRecieversGender("male");
		paymentDetails.setRecieversName("nipun");
	    paymentDetails.setRecieversNumber(9999);
	    paymentDetails.setPaymentAmount(9999);
		paymentDetails.setUser(userdetails);
		PaymentDetailsDAO paymentDetailsDAO = new PaymentDetailsDAOImpl();
		 flag=paymentDetailsDAO.addPayment(paymentDetails);
		
		assertTrue( flag );

	}
	@Ignore
	@Test
	public void deletePaymentTest(){
		boolean flag=false;
		System.out.println("delete payment begins");
		PaymentDetailsDAO paymentdetailsdao = new PaymentDetailsDAOImpl();
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setPaymentId(01);
		flag=paymentdetailsdao.deletePayment(paymentDetails);
		assertTrue( flag );
	}
	@Ignore
	@Test
    public void getallpaymenttest(){
System.out.println("getallpayment begin");
		
		PaymentDetailsDAO paymentdetailsdao = new PaymentDetailsDAOImpl();
		List<PaymentDetails> list = paymentdetailsdao.getallpayment();
		
		boolean flag = false;
		if(list!=null)
		{
			
			   
			Iterator item = list.iterator();
			while(item.hasNext()){
				PaymentDetails p=(PaymentDetails) item.next();
			//	System.out.println("payment amount  "+ p.getPaymentAmount());
			//	System.out.println("payment id  "+ p.getPaymentDetailsId());
			//	System.out.println("payment type  "+ p.getPaymentType());
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
    public void getpaymentbyidtest(){
		System.out.println("getpaymentbyid begins");
		PaymentDetailsDAO paymentdetailsdao = new PaymentDetailsDAOImpl();
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails=paymentdetailsdao.getamountbyid(4);
		boolean flag = false;
		if(paymentDetails!=null){
			//System.out.println("payment amount = "+paymentDetails.getPaymentAmount());
			//System.out.println("paymentId = "+paymentDetails.getPaymentDetailsId());
			System.out.println("product type = "+paymentDetails.getPaymentType());
			
     		flag=true;
		}
		else{
          flag=false;
		}
		
		assertTrue( flag );
    }
	@Ignore
	@Test
	public void updatepaymenttest(){
		boolean flag=false;
		System.out.println("update payment begins");
		PaymentDetailsDAO paymentdetailsdao = new PaymentDetailsDAOImpl();
		PaymentDetails paymentDetails = new PaymentDetails();
		flag=paymentdetailsdao.updatePayment(paymentDetails);
		assertTrue( flag );
	}
}
