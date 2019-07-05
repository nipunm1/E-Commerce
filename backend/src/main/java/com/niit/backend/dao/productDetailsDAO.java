package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.UserDetails;
import com.niit.backend.model.productDetails;

public interface productDetailsDAO {
	public boolean addProduct(productDetails product);
	public boolean deleteProduct(productDetails product);
	public boolean UpdateProduct(productDetails product);
	public List<productDetails> getallproduct();
	public productDetails getproductbyid(int ProductID);
}
