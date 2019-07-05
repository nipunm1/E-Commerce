package com.niit.backend.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="e_SupplierDetails")
@Entity
@Component
public class SupplierDetails {
	@Id
	@GeneratedValue
int SupplierID;
private String SupplierName;
private String SupplierEmail;
private String SupplierAddress;
private String SupplierNumber;
public String getSupplierEmail() {
	return SupplierEmail;
}
public void setSupplierEmail(String supplierEmail) {
	SupplierEmail = supplierEmail;
}
public String getSupplierAddress() {
	return SupplierAddress;
}
public void setSupplierAddress(String supplierAddress) {
	SupplierAddress = supplierAddress;
}
public String getSupplierNumber() {
	return SupplierNumber;
}
public void setSupplierNumber(String supplierNumber) {
	SupplierNumber = supplierNumber;
}
public int getSupplierID() {
	return SupplierID;
}
public void setSupplierID(int supplierID) {
	SupplierID = supplierID;
}
public String getSupplierName() {
	return SupplierName;
}
public void setSupplierName(String supplierName) {
	SupplierName = supplierName;
}
//************************************************************************************
@OneToMany(mappedBy="supplier")
private List<productDetails> ProductDetails;
public List<productDetails> getProductDetails() {
	return ProductDetails;
}
public void setProductDetails(List<productDetails> productDetails) {
	ProductDetails = productDetails;
}
}
