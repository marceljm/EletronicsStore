package com.marceljm.service;

import java.util.List;

public interface CategoryService {

	public List<String> selectMainCategory();

	public List<String> selectSubCategory(String mainCategory);

	public List<String> selectThirdCategory(String thirdCategory);
}
