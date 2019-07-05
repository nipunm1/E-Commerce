package com.niit.backend.dao;

import java.sql.*;
import java.util.List;

import com.niit.backend.model.UserDetails;

public interface UserDetailsDAO {
public boolean addUser(UserDetails user);
public boolean deleteUser(UserDetails user);
public boolean UpdateUser(UserDetails user);
public List<UserDetails> getalluser();
public UserDetails getuserbyemail(String UserEmail);
}
