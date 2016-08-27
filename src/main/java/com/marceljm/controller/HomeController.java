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

	/* selection */
	private String selectedMainCategory = "Eletrônicos";

	/* init */
	@PostConstruct
	private void init() {
		mainCategoryList = categoryService.selectMainCategory();
	}

	/* getters */
	public List<String> getMainCategoryList() {
		return mainCategoryList;
	}

	/* getters and setters */
	public String getSelectedMainCategory() {
		return selectedMainCategory;
	}

	public void setSelectedMainCategory(String selectedMainCategory) {
		this.selectedMainCategory = selectedMainCategory;
	}

}
