package com.marceljm.persistence;

import java.util.List;

import com.marceljm.entity.MainSubCategory;
import com.marceljm.entity.SubThirdCategory;

public interface CategoryDAO {

	public List<String> selectMainCategory();

	public List<String> selectSubCategory(String mainCategory);

	public List<String> selectThirdCategory(String subCategory);

	public List<MainSubCategory> selectMainSubCategory();

	public List<SubThirdCategory> selectSubThirdCategory();
}
