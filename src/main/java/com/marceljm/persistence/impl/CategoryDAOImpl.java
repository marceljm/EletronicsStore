package com.marceljm.persistence.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.marceljm.entity.MainSubCategory;
import com.marceljm.entity.SubThirdCategory;
import com.marceljm.persistence.CategoryDAO;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectMainCategory() {
		return (List<String>) manager.createQuery("SELECT DISTINCT mainCategory FROM Product ORDER BY mainCategory")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectSubCategory(String mainCategory) {
		return (List<String>) manager.createQuery("SELECT DISTINCT subCategory FROM Product WHERE mainCategory = '"
				+ mainCategory + "' ORDER BY subCategory").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> selectThirdCategory(String subCategory) {
		return (List<String>) manager.createQuery("SELECT DISTINCT thirdCategory FROM Product WHERE subCategory = '"
				+ subCategory + "' ORDER BY thirdCategory").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MainSubCategory> selectMainSubCategory() {
		return (List<MainSubCategory>) manager.createQuery("SELECT a FROM MainSubCategory a ORDER BY id")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubThirdCategory> selectSubThirdCategory() {
		return (List<SubThirdCategory>) manager.createQuery("SELECT a FROM SubThirdCategory a ORDER BY id")
				.getResultList();
	}
}
