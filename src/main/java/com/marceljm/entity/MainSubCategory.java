package com.marceljm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the mainSubCategory database table.
 * 
 */
@Entity
@Table(name = "mainSubCategory")
@NamedQuery(name = "MainSubCategory.findAll", query = "SELECT m FROM MainSubCategory m")
public class MainSubCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private double id;

	private String mainCategory;

	private String subCategory;

	public MainSubCategory() {
	}

	public double getId() {
		return this.id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getMainCategory() {
		return this.mainCategory;
	}

	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}

	public String getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

}