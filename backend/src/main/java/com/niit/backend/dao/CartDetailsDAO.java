package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.CartDetails;

public interface CartDetailsDAO {
public boolean addCart(CartDetails cart);
public boolean deleteCart(CartDetails cart);
public boolean updateCart(CartDetails cart);
public List<CartDetails> getallCart();
public CartDetails getcartbyid(int CartId);
}
