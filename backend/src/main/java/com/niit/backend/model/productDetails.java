package com.niit.backend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="e_ProductDetails")
@Entity
@Component
public class productDetails {
private String ProductDiscription;
private String ProductName;
@Id
@GeneratedValue
int ProductID;


public int getProductID() {
	return ProductID;
}
public void setProductID(int productID) {
	ProductID = productID;
}
public String getProductDiscription() {
	return ProductDiscription;
}
public void setProductDiscription(String productDiscription) {
	ProductDiscription = productDiscription;
}
public String getProductName() {
	return ProductName;
}
public void setProductName(String productName) {
	ProductName = productName;
}
public int getProductPrice() {
	return ProductPrice;
}
public void setProductPrice(int productPrice) {
	ProductPrice = productPrice;
}
public String getProductImage() {
	return ProductImage;
}
public void setProductImage(String productImage) {
	ProductImage = productImage;
}
int ProductPrice;

private String ProductImage;
//*********************************************************************
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "CategoryId") private CategoryDetails category;

public CategoryDetails getCategory() {
	return category;
}
public void setCategory(CategoryDetails category) {
	this.category = category;
}
@ManyToOne
@JoinColumn(name="SupplierID") private SupplierDetails supplier;

public SupplierDetails getSupplier() {
	return supplier;
}
public void setSupplier(SupplierDetails supplier) {
	this.supplier = supplier;
}
@OneToMany(mappedBy="product")
private List<CartDetails> cartDetails;

public List<CartDetails> getCartDetails() {
	return cartDetails;
}
public void setCartDetails(List<CartDetails> cartDetails) {
	this.cartDetails = cartDetails;
}

}
