package com.marceljm.controller;

import java.text.Collator;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.marceljm.entity.NodeCategory;
import com.marceljm.entity.Product;
import com.marceljm.service.CategoryService;
import com.marceljm.service.IconService;
import com.marceljm.service.ProductService;
import com.marceljm.util.TextUtil;

@Controller
@Scope("session")
public class HomeController {

	/* services */
	@Inject
	private CategoryService categoryService;
	@Inject
	private ProductService productService;
	@Inject
	private IconService iconService;

	/* lists */
	private List<String> mainCategoryList;
	private List<String> subCategoryList;
	private List<String> thirdCategoryList;
	private List<Product> productList;

	/* maps */
	private Map<String, List<String>> mainSubCategoryMap;
	private Map<String, List<String>> subThirdCategoryMap;

	/* selection */
	private String selectedMainCategory;
	private String selectedSubCategory;
	private String selectedThirdCategory;

	/* render */
	private boolean thirdCategoryRendered = true;

	/* sort */
	private Collator collator = Collator.getInstance();

	/* tree */
	private TreeNode root;

	/* init */
	@PostConstruct
	private void init() {
		collator.setStrength(Collator.PRIMARY);

		mainSubCategoryMap = categoryService.selectMainSubMapCategory();
		subThirdCategoryMap = categoryService.selectSubThirdMapCategory();

		mainCategoryList = categoryService.selectMainCategory();
		selectedMainCategory = "Eletrônicos";

		subCategoryList = mainSubCategoryMap.get(selectedMainCategory);
		Collections.sort(subCategoryList, collator);
		selectedSubCategory = "TV";

		thirdCategoryList = subThirdCategoryMap.get(selectedSubCategory);
		Collections.sort(thirdCategoryList, collator);
		selectedThirdCategory = "TV LED";

		root = tree();
	}

	/* tree */
	public TreeNode tree() {
		NodeCategory nodeCategory = new NodeCategory(null, null, null);
		TreeNode root = new DefaultTreeNode(nodeCategory, null);
		for (String mainCategory : mainCategoryList) {
			TreeNode mainNode = new DefaultTreeNode(
					new NodeCategory(mainCategory, null, iconService.icon(mainCategory)), root);

			List<String> subList = mainSubCategoryMap.get(mainCategory);
			Collections.sort(subList, collator);
			for (String subCategory : subList) {
				TreeNode subNode = new DefaultTreeNode(new NodeCategory(subCategory, null, "fa fa-plus-circle"),
						mainNode);

				List<String> thirdList = subThirdCategoryMap.get(subCategory);
				Collections.sort(thirdList, collator);
				for (String thirdCategory : thirdList) {
					new DefaultTreeNode(
							new NodeCategory(
									thirdCategory, TextUtil.normalize(mainCategory) + "/"
											+ TextUtil.normalize(subCategory) + "/" + TextUtil.normalize(thirdCategory),
									"fa fa-search"),
							subNode);
				}
			}
		}
		return root;
	}

	/* listeners */
	public void updateSubCategory() {
		subCategoryList = mainSubCategoryMap.get(selectedMainCategory);
		Collections.sort(subCategoryList, collator);
		selectedSubCategory = subCategoryList.get(0);

		updateThirdCategory();
	}

	public void updateThirdCategory() {
		thirdCategoryList = subThirdCategoryMap.get(selectedSubCategory);
		Collections.sort(thirdCategoryList, collator);
		selectedThirdCategory = thirdCategoryList.get(0);

		if (thirdCategoryList.isEmpty() || (thirdCategoryList.size() == 1 && thirdCategoryList.get(0).isEmpty()))
			thirdCategoryRendered = false;
		else
			thirdCategoryRendered = true;
	}

	public void search() {
		productList = productService.select(selectedMainCategory, selectedSubCategory, selectedThirdCategory);
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

	public List<Product> getProductList() {
		return productList;
	}

	public TreeNode getRoot() {
		return root;
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
