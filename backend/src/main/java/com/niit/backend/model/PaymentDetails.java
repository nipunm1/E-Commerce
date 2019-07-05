package com.niit.backend.model;

import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Table(name="e_paymentDetails")
@Entity
@Component
public class PaymentDetails{
	
	public long getRecieversNumber() {
		return RecieversNumber;
	}
	public void setRecieversNumber(long recieversNumber) {
		RecieversNumber = recieversNumber;
	}
	@Id
     @GeneratedValue
	int PaymentId;
	
public int getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(int PaymentId) {
		this.PaymentId = PaymentId;
	}
private String RecieversName;
private String RecieversAddress;
private String RecieversGender;
private String RecieversEmail;
long RecieversNumber;
private String PaymentType;
int PaymentAmount;

public int getPaymentAmount() {
	return PaymentAmount;
}
public void setPaymentAmount(int paymentAmount) {
	PaymentAmount = paymentAmount;
}
public String getRecieversName() {
	return RecieversName;
}
public void setRecieversName(String recieversName) {
	RecieversName = recieversName;
}
public String getRecieversAddress() {
	return RecieversAddress;
}
public void setRecieversAddress(String recieversAddress) {
	RecieversAddress = recieversAddress;
}
public String getRecieversGender() {
	return RecieversGender;
}
public void setRecieversGender(String recieversGender) {
	RecieversGender = recieversGender;
}
public String getRecieversEmail() {
	return RecieversEmail;
}
public void setRecieversEmail(String recieversEmail) {
	RecieversEmail = recieversEmail;
}
public String getPaymentType() {
	return PaymentType;
}
public void setPaymentType(String paymentType) {
	PaymentType = paymentType;
}
//**************************************************************************
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "UserEmail")

private UserDetails user;
public UserDetails getUser() {
	return user;
}
public void setUser(UserDetails user) {
	this.user = user;
}

}
