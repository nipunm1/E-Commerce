package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.SupplierDetails;

public interface SupplierDetailsDAO {
	public boolean addSupplier(SupplierDetails supplier);
	public boolean deleteSupplier(SupplierDetails supplier);
	public boolean UpdateSupplier(SupplierDetails supplier);
	public List<SupplierDetails> getallSupplier();
	public SupplierDetails getsupplierbyid(int SupplierID);

}
