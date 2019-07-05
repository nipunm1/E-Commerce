package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.PaymentDetails;

public interface PaymentDetailsDAO {
public boolean addPayment(PaymentDetails payment);
public boolean deletePayment(PaymentDetails payment);
public boolean updatePayment(PaymentDetails payment);
public List<PaymentDetails> getallpayment();
public PaymentDetails getamountbyid(int paymentDetailsId);
}
