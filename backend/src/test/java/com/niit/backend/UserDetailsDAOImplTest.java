package com.niit.backend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.UserDetailsDAO;
import com.niit.backend.daoimpl.UserDetailsDAOImpl;
import com.niit.backend.model.UserDetails;

public class UserDetailsDAOImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println(" ");
	}

	@Ignore
	public void test() {
		
		System.out.println("Test fun ");
	
		
	}
	

	@Ignore
	@Test
	public void addUserTest() {
		
		System.out.println("addUser Begin ");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserAadharId("1111111111111111111111");
		userDetails.setUserEmail("nipunmiglani.96@gmail.com");
		userDetails.setUserPassword("1234");
		userDetails.setUserAddress("pitampura");
		userDetails.setUserMobile("9999664813");
		userDetails.setUserName("Nipun 	Miglani");
		//userDetails.setUserRole("Admin");
		//userDetails.setUserStatus("yes");
		UserDetailsDAO userDetailsDAO = new UserDetailsDAOImpl();
		boolean flag=userDetailsDAO.addUser(userDetails);
		
		assertTrue( flag );
	}
	
	@Ignore
	@Test
	public  void getallusertest(){
		System.out.println("getalluser begin");
		
		UserDetailsDAO userdetailsdao = new UserDetailsDAOImpl();
		List<UserDetails> list =userdetailsdao.getalluser();
		
		boolean flag = false;
		if(list!=null)
		{
			flag=true;
			   
			Iterator item = list.iterator();
			while(item.hasNext()){
				UserDetails u=(UserDetails) item.next();
				System.out.println("user email"+u.getUserEmail());
				System.out.println("user password"+u.getUserPassword());
				System.out.println("user name"+u.getUserName());
				System.out.println("user address"+u.getUserAddress());
				System.out.println("user mobile number"+u.getUserMobile());
				System.out.println("user aadhar id"+u.getUserAadharId());
				System.out.println("user role"+u.getUserRole());
				System.out.println("user status"+u.getUserStatus());
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
	public void getuserbyemailtest(){
		System.out.println("getuserbyemail begins");
		UserDetailsDAO userdetailsdao = new UserDetailsDAOImpl();
		UserDetails userDetails = new UserDetails();
		userDetails=userdetailsdao.getuserbyemail("niit@niit.com");
		boolean flag = false;
		if(userDetails!=null){
			System.out.println("user email"+userDetails.getUserEmail()); 
			System.out.println("user name"+userDetails.getUserName());
			System.out.println("user aadhar id"+userDetails.getUserAadharId());
			System.out.println("user mobile number"+userDetails.getUserMobile());
			System.out.println("user password"+userDetails.getUserPassword());
			System.out.println("user address"+userDetails.getUserAddress());
			System.out.println("user role"+userDetails.getUserRole());
			System.out.println("user status"+userDetails.getUserStatus());
			flag=true;
		}
		else{
          flag=false;
		}
		
		assertTrue( flag );
	}
    @Ignore
	@Test
	public void deleteUserTest(){
		boolean flag=false;
		System.out.println("delete user begins");
		UserDetailsDAO userdetailsdao = new UserDetailsDAOImpl();
		UserDetails userDetails = new UserDetails();
		userDetails.setUserEmail("niit1@niit.com");
		flag=userdetailsdao.deleteUser(userDetails);
		assertTrue( flag );
		
		
	}
	@Ignore
	@Test
	public void updateUserTest(){
		boolean flag=false;
		System.out.println("update user begins");
		UserDetailsDAO userdetailsdao = new UserDetailsDAOImpl();
		UserDetails userDetails = new UserDetails();
		flag=userdetailsdao.UpdateUser(userDetails);
		assertTrue( flag );
		
	}
}
