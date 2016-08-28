package com.marceljm.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.marceljm.persistence.CategoryDAO;
import com.marceljm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryDAO dao;

	@Override
	public List<String> selectMainCategory() {
		return dao.selectMainCategory();
	}

	@Override
	public List<String> selectSubCategory(String mainCategory) {
		return dao.selectSubCategory(mainCategory);
	}

	@Override
	public List<String> selectThirdCategory(String subCategory) {
		return dao.selectThirdCategory(subCategory);
	}

}
