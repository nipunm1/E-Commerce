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

@Table(name="e_categorydetails")
@Entity
@Component
public class CategoryDetails {
@Id
@GeneratedValue
int CategoryId;

public int getCategoryId() {
	return CategoryId;
}

public void setCategoryId(int categoryId) {
	CategoryId = categoryId;
}

public String getCategoryName() {
	return CategoryName;
}

public void setCategoryName(String categoryName) {
	CategoryName = categoryName;
}

private String CategoryName;

//******************************************************************
@OneToMany(mappedBy="category",fetch = FetchType.EAGER)
private List<productDetails> ProductDetails;

public List<productDetails> getProductDetails() {
	return ProductDetails;
}

public void setProductDetails(List<productDetails> productDetails) {
	ProductDetails = productDetails;
}

}
