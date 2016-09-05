package com.marceljm.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.marceljm.entity.Product;
import com.marceljm.persistence.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> select(String mainCategory, String subCategory, String thirdCategory) {
		return (List<Product>) manager
				.createQuery("SELECT a FROM Product a WHERE mainCategory = '" + mainCategory + "' AND subCategory = '"
						+ subCategory + "' AND thirdCategory = '" + thirdCategory + "' ORDER BY price")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> select(String path) {
		return (List<Product>) manager.createQuery("SELECT a FROM Product a WHERE path = '" + path + "' ORDER BY price")
				.getResultList();
	}

}
