package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.StockDetails;
import com.niit.backend.model.productDetails;


public interface StockDetailsDAO {
	public boolean addStock(StockDetails stock);
	public boolean deleteStock(StockDetails stock);
	public boolean UpdateStock(StockDetails stock);
	public List<StockDetails> getallStock();
	public StockDetails getstockbyid(int StockId);
	public StockDetails getstockbyproductid(int ProductID);
	public boolean updateaddstock(int ProductID,int in_stock);
	public boolean updateminusstock(int ProductID,int in_stock);
}
