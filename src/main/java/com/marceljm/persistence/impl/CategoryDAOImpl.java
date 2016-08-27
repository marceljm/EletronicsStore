package com.marceljm.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.marceljm.persistence.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectMainCategory() {
		return (List<String>) manager.createQuery("SELECT DISTINCT mainCategory FROM Product ORDER BY mainCategory").getResultList();
	}

}
