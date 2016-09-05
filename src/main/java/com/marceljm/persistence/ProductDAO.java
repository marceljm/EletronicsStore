package com.marceljm.persistence;

import java.util.List;

import com.marceljm.entity.Product;

public interface ProductDAO {

	public List<Product> select(String mainCategory, String subCategory, String thirdCategory);

	public List<Product> select(String path);

}
