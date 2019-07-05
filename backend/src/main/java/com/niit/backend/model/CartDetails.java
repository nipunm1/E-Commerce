package com.niit.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="e_cartdetails")
@Entity
@Component
public class CartDetails {
@Id
@GeneratedValue
int CartId;
int CartQuantity;
public int getCartId() {
	return CartId;
}
public void setCartId(int cartId) {
	CartId = cartId;
}
public int getCartQuantity() {
	return CartQuantity;
}
public void setCartQuantity(int cartQuantity) {
	CartQuantity = cartQuantity;
}
public int getCartTotalAmount() {
	return CartTotalAmount;
}
public void setCartTotalAmount(int cartTotalAmount) {
	CartTotalAmount = cartTotalAmount;
}
public String getCartItems() {
	return CartItems;
}
public void setCartItems(String cartItems) {
	CartItems = cartItems;
}
int CartTotalAmount;
private String CartItems;
Date cartdateandtime;
public Date getCartdateandtime() {
	return cartdateandtime;
}
public void setCartdateandtime(Date cartdateandtime) {
	this.cartdateandtime = cartdateandtime;
}
char carttran;
public char getCarttran() {
	return carttran;
}
public void setCarttran(char carttran) {
	this.carttran = carttran;
}
//****************************************************************
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="ProductID") private productDetails product;
public productDetails getProduct() {
	return product;
}
public void setProduct(productDetails product) {
	this.product = product;
}
@ManyToOne
@JoinColumn(name="UserEmail") private UserDetails user;
public UserDetails getUser() {
	return user;
}
public void setUser(UserDetails user) {
	this.user = user;
}
}
