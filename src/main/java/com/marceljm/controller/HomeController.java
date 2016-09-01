package com.marceljm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.service.CategoryService;

@Controller
@Scope("session")
public class HomeController {

	/* services */
	@Inject
	private CategoryService categoryService;

	/* lists */
	private List<String> mainCategoryList;
	private List<String> subCategoryList;
	private List<String> thirdCategoryList;

	/* maps */
	private Map<String, List<String>> mainSubCategoryMap;
	private Map<String, List<String>> subThirdCategoryMap;

	/* selection */
	private String selectedMainCategory;
	private String selectedSubCategory;
	private String selectedThirdCategory;

	/* render */
	private boolean thirdCategoryRendered;

	/* init */
	@PostConstruct
	private void init() {
		mainSubCategoryMap = categoryService.selectMainSubMapCategory();
		subThirdCategoryMap = categoryService.selectSubThirdMapCategory();

		mainCategoryList = new ArrayList<String>(mainSubCategoryMap.keySet());
		selectedMainCategory = "Eletrônicos";

		subCategoryList = mainSubCategoryMap.get(selectedMainCategory);
		selectedSubCategory = "TV";

		thirdCategoryList = subThirdCategoryMap.get(selectedSubCategory);
		selectedThirdCategory = "TV LED";
	}

	/* listeners */
	public void updateSubCategory() {
		subCategoryList = mainSubCategoryMap.get(selectedMainCategory);
		selectedSubCategory = subCategoryList.get(0);

		updateThirdCategory();
	}

	public void updateThirdCategory() {
		thirdCategoryList = subThirdCategoryMap.get(selectedSubCategory);
		selectedThirdCategory = thirdCategoryList.get(0);

		if (thirdCategoryList.isEmpty() || (thirdCategoryList.size() == 1 && thirdCategoryList.get(0).isEmpty()))
			thirdCategoryRendered = false;
		else
			thirdCategoryRendered = true;
	}

	/* getters */
	public List<String> getMainCategoryList() {
		return mainCategoryList;
	}

	public List<String> getSubCategoryList() {
		return subCategoryList;
	}

	public List<String> getThirdCategoryList() {
		return thirdCategoryList;
	}

	public boolean isThirdCategoryRendered() {
		return thirdCategoryRendered;
	}

	/* getters and setters */
	public String getSelectedMainCategory() {
		return selectedMainCategory;
	}

	public void setSelectedMainCategory(String selectedMainCategory) {
		this.selectedMainCategory = selectedMainCategory;
	}

	public String getSelectedSubCategory() {
		return selectedSubCategory;
	}

	public void setSelectedSubCategory(String selectedSubCategory) {
		this.selectedSubCategory = selectedSubCategory;
	}

	public String getSelectedThirdCategory() {
		return selectedThirdCategory;
	}

	public void setSelectedThirdCategory(String selectedThirdCategory) {
		this.selectedThirdCategory = selectedThirdCategory;
	}

}
