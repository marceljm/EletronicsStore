package com.marceljm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.marceljm.entity.KeyValue;
import com.marceljm.entity.MainSubCategory;
import com.marceljm.entity.SubThirdCategory;
import com.marceljm.persistence.CategoryDAO;
import com.marceljm.persistence.GenericDAO;
import com.marceljm.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryDAO dao;

	@Inject
	private GenericDAO<MainSubCategory> mainSubCategoryDao;

	@Inject
	private GenericDAO<SubThirdCategory> subThirdCategoryDao;

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

	@Override
	public Map<String, List<String>> selectMapCategory(int type) {
		if (type == 1) {
			for (MainSubCategory i : mainSubCategoryDao.select(MainSubCategory.class)) {
				
				
			};
		}
		else {
			subThirdCategoryDao.select(SubThirdCategory.class);
		}

		return keyValueListToMap(type == 1 ? 
				: subThirdCategoryDAO.select(SubThirdCategory.class));
	}
	

	

	private Map<String, List<String>> keyValueListToMap(List<KeyValue> keyValueList) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		String key, value;
		for (KeyValue keyValue : keyValueList) {
			key = keyValue.getKey();
			value = keyValue.getValue();
			if (map.get(key) == null) {
				List<String> list = new ArrayList<String>();
				list.add(value);
				map.put(key, list);
			} else
				map.get(key).add(value);
		}
		return map;
	}

}
