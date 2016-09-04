package com.marceljm.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.marceljm.entity.Product;
import com.marceljm.persistence.ProductDAO;
import com.marceljm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductDAO dao;

	@Override
	public List<Product> select(String mainCategory, String subCategory, String thirdCategory) {
		return dao.select(mainCategory, subCategory, thirdCategory);
	}

}
