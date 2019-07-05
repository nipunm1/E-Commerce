package com.niit.backend.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
@Table(name="e_UserDetails")
@Entity
@Component
public class UserDetails {
	@Id
	
private String UserEmail;
	
	
public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserAddress() {
		return UserAddress;
	}
	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}
	public String getUserMobile() {
		return UserMobile;
	}
	public void setUserMobile(String userMobile) {
		UserMobile = userMobile;
	}
	public String getUserAadharId() {
		return UserAadharId;
	}
	public void setUserAadharId(String userAadharId) {
		UserAadharId = userAadharId;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	public String getUserStatus() {
		return UserStatus;
	}
	public void setUserStatus(String userStatus) {
		UserStatus = userStatus;
	}
private String UserPassword;
private String UserName;
private String UserAddress;
private String UserMobile;
private String UserAadharId;



private String UserRole;
private String UserStatus;

//********************************************************************

@OneToMany(mappedBy="user",fetch = FetchType.EAGER)
private List<CartDetails> cartdetails;


public List<CartDetails> getCartdetails() {
	return cartdetails;
}
public void setCartdetails(List<CartDetails> cartdetails) {
	this.cartdetails = cartdetails;
}
}
