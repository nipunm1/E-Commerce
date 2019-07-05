package com.niit.backend.dao;

import java.util.List;

import com.niit.backend.model.CategoryDetails;

public interface CategoryDetailsDAO {
public boolean addCategory(CategoryDetails category);
public boolean deleteCategory(CategoryDetails category);
public boolean updateCategory(CategoryDetails category);
public List<CategoryDetails> getallCategory();
public CategoryDetails getcategorybyid(int CategoryId);
}
