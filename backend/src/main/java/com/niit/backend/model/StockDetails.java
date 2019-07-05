package com.niit.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="e_StockDetails")
@Entity
@Component
public class StockDetails {
	@Id	
	@GeneratedValue(strategy=GenerationType.AUTO)
int StockId;
int in_stock;

public int getStockId() {
	return StockId;
}
public void setStockId(int stockId) {
	StockId = stockId;
}
public int getIn_stock() {
	return in_stock;
}
public void setIn_stock(int in_stock) {
	this.in_stock = in_stock;
}
//********************************************************************
@OneToOne(targetEntity=productDetails.class)
private productDetails product;

public productDetails getProduct() {
	return product;
}
public void setProduct(productDetails product) {
	this.product = product;
}

}
