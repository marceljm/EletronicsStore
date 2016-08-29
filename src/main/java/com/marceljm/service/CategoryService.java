package com.marceljm.service;

import java.util.List;
import java.util.Map;

public interface CategoryService {

	public List<String> selectMainCategory();

	public List<String> selectSubCategory(String mainCategory);

	public List<String> selectThirdCategory(String thirdCategory);

	public Map<String, List<String>> selectMapCategory(int type);
}
