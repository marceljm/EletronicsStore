package com.marceljm.persistence;

import java.util.List;

public interface CategoryDAO {

	public List<String> selectMainCategory();

	public List<String> selectSubCategory(String mainCategory);

	public List<String> selectThirdCategory(String subCategory);
}
