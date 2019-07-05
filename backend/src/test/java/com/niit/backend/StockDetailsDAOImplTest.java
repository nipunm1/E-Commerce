package com.niit.backend;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.niit.backend.dao.PaymentDetailsDAO;
import com.niit.backend.dao.StockDetailsDAO;
import com.niit.backend.dao.productDetailsDAO;
import com.niit.backend.daoimpl.PaymentDetailsDAOImpl;
import com.niit.backend.daoimpl.StockDetailsDAOImpl;
import com.niit.backend.daoimpl.productDetailsDAOImpl;
import com.niit.backend.model.PaymentDetails;
import com.niit.backend.model.StockDetails;
import com.niit.backend.model.productDetails;

public class StockDetailsDAOImplTest {

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
    public void addStock(){
    	System.out.println("addstocktest begins");
    	boolean flag = false;
    	StockDetails stockdetails = new StockDetails();
    	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
    	productDetails productdetails = new productDetails();
    	productdetails.setProductID(1);
    	stockdetails.setIn_stock(1);
    
    	stockdetails.setProduct(productdetails);
    	flag = stockdetailsdao.addStock(stockdetails);
    	assertTrue( flag );
    }
    @Ignore
    @Test
    public void deleteStockTest(){
    	boolean flag=false;
		System.out.println("delete stocktest begins");
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		StockDetails stockDetails = new StockDetails();
		stockDetails.setStockId(0);
		flag=stockdetailsdao.deleteStock(stockDetails);
		assertTrue( flag );
    }
    @Ignore
    @Test
    public void getallstocktest(){
System.out.println("getallstock begin");
		
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		List<StockDetails> list = stockdetailsdao.getallStock();
		
		boolean flag = false;
		if(list!=null)
		{
			
			   
			Iterator item = list.iterator();
			while(item.hasNext()){
				StockDetails stock=(StockDetails) item.next();
				System.out.println("Stock available =   "+ stock.getIn_stock());
				System.out.println("stock id =  "+ stock.getStockId());
				
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
    public void getstockbyidtest(){
    	System.out.println("getstockbyid begins");
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		StockDetails stockDetails = new StockDetails();
		stockDetails=stockdetailsdao.getstockbyid(0);
		boolean flag = false;
		if(stockDetails!=null){
			System.out.println("Stock available =  "+stockDetails.getIn_stock());
			System.out.println("stock id =  "+ stockDetails.getStockId());
			flag=true;
		}
		else{
          flag=false;
		}
		
		assertTrue( flag );
    }
    @Ignore
    @Test
    public void getstockbyproductid(){
    	System.out.println("getstockbyproductid begins");
    	StockDetails stockdetails = new StockDetails();
    	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
    	productDetails productdetails = new productDetails();
    	//stockdetails = stockdetailsdao.getstockbyproductid(03);
    	boolean flag = false;
		if(stockdetails!=null){
			productdetails=stockdetails.getProduct();
			
			System.out.println("Product Id =  "+productdetails.getProductID());
		    System.out.println("Stock available =  "+stockdetails.getIn_stock());
			System.out.println("stock id =  "+ stockdetails.getStockId());
			flag=true;
		}
		else{
          flag=false;
		}
		
		assertTrue( flag );
     }
    @Ignore
    @Test
    public void updatestocktest(){
    	boolean flag=false;
		System.out.println("update stock begins");
		StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
		StockDetails stockDetails = new StockDetails();
		flag=stockdetailsdao.UpdateStock(stockDetails);
		assertTrue( flag );
    }
    @Ignore
    @Test
    public void updateaddstocktest(){
    	boolean flag = false;
    	System.out.println("update add stock test begins");
    	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
    	StockDetails stockdetails = new StockDetails();
    	flag = stockdetailsdao.updateaddstock(01,5);
    	assertTrue(flag);
    }
    @Ignore
    @Test
    public void updateminusstocktest(){
    	boolean flag = false;
    	System.out.println("update minus stock test begins");
    	StockDetailsDAO stockdetailsdao = new StockDetailsDAOImpl();
    	StockDetails stockdetails = new StockDetails();
    	flag = stockdetailsdao.updateminusstock(01, 5);
    	assertTrue(flag);
    }
}
