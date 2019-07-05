package com.niit.backend;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.CartDetailsDAO;
import com.niit.backend.dao.CategoryDetailsDAO;
import com.niit.backend.daoimpl.CartDetailsDAOImpl;
import com.niit.backend.daoimpl.CategoryDetailsDAOImpl;
import com.niit.backend.model.CartDetails;
import com.niit.backend.model.CategoryDetails;
import com.niit.backend.model.PaymentDetails;
import com.niit.backend.model.UserDetails;
import com.niit.backend.model.productDetails;

public class CartDetailsDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("");
	}

	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
   
	@Test
	public void addCartTest(){
		boolean flag=false;
System.out.println("addcartBegin ");
productDetails Productdetails = new productDetails();
UserDetails userdetails = new UserDetails();
Productdetails.setProductID(01);
userdetails.setUserEmail("niit@niit.com");
		
				CartDetails cartDetails = new CartDetails();
				cartDetails.setProduct(Productdetails);
				cartDetails.setUser(userdetails);
		        cartDetails.setCartItems("Camera");
				cartDetails.setCartQuantity(1);
				cartDetails.setCartTotalAmount(50000);
				cartDetails.setCartdateandtime(new Date());
				cartDetails.setCarttran('n');
				CartDetailsDAO cartDetailsDAO = new CartDetailsDAOImpl();
				 flag=cartDetailsDAO.addCart(cartDetails);
				
				assertTrue( flag );
	}
    @Ignore
    @Test
    public void getallCartTest(){
    	System.out.println("getallcart begin");
		CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
		List<CartDetails> list = cartdetailsdao.getallCart();
		
		boolean flag = false;
		if(list!=null)
		{
			
			   
			Iterator item = list.iterator();
			while(item.hasNext()){
				CartDetails c=(CartDetails) item.next();
				System.out.println("cart id  =   "+c.getCartId());
				System.out.println("cart items  =  "+c.getCartItems());
				System.out.println("cart quantity  =  "+c.getCartQuantity());
				System.out.println("cart total  =  "+c.getCartTotalAmount());
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
    public void getCartByIdTest(){
    	System.out.println("getcartbyid begins");
		CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
		CartDetails cartDetails = new CartDetails();
		cartDetails=cartdetailsdao.getcartbyid(01);
		boolean flag = false;
		if(cartDetails!=null){
			System.out.println("cart id = "+ cartDetails.getCartId());
			System.out.println("cart total amount = "+ cartDetails.getCartTotalAmount());
			System.out.println("cart quantity = "+ cartDetails.getCartQuantity() );
			System.out.println("cart items = "+ cartDetails.getCartItems());
     		flag=true;
		}
		else{
          flag=false;
		}
		
		assertTrue( flag );


    }
    @Ignore
    @Test
    public void deleteCartTest(){
    	boolean flag=false;
		System.out.println("delete cart begins");
		CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
		CartDetails cartDetails = new CartDetails();
		cartDetails.setCartId(03);
		flag=cartdetailsdao.deleteCart(cartDetails);
		assertTrue( flag );
    }
    @Ignore
    @Test
    public void updateCartTest(){
    	boolean flag=false;
		System.out.println("update cart begins");
		CartDetailsDAO cartdetailsdao = new CartDetailsDAOImpl();
		CartDetails cartDetails = new CartDetails();
		flag=cartdetailsdao.updateCart(cartDetails);
		assertTrue( flag );
    }
	
}
