package com.marceljm.controller;

import java.util.List;

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

	/* selection */
	private String selectedMainCategory;
	private String selectedSubCategory;
	private String selectedThirdCategory;

	/* init */
	@PostConstruct
	private void init() {
		mainCategoryList = categoryService.selectMainCategory();
		selectedMainCategory = "Eletrônicos";

		subCategoryList = categoryService.selectSubCategory(selectedMainCategory);
		selectedSubCategory = "TV";

		thirdCategoryList = categoryService.selectThirdCategory(selectedSubCategory);
		selectedThirdCategory = "TV LED";
	}

	/* listeners */
	public void updateSubCategory() {
		subCategoryList = categoryService.selectSubCategory(selectedMainCategory);
		selectedSubCategory = subCategoryList.get(0);

		updateThirdCategory();
	}

	public void updateThirdCategory() {
		thirdCategoryList = categoryService.selectThirdCategory(selectedSubCategory);
		selectedThirdCategory = thirdCategoryList.get(0);
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
