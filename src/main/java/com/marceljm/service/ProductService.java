package com.marceljm.service;

import java.util.List;

import com.marceljm.entity.Product;

public interface ProductService {

	public List<Product> select(String mainCategory, String subCategory, String thirdCategory);

}
