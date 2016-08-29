package com.marceljm.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the subThirdCategory database table.
 * 
 */
@Entity
@Table(name = "subThirdCategory")
@NamedQuery(name = "SubThirdCategory.findAll", query = "SELECT s FROM SubThirdCategory s")
public class SubThirdCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private double id;

	private String subCategory;

	private String thirdCategory;

	public SubThirdCategory() {
	}

	public double getId() {
		return this.id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public String getSubCategory() {
		return this.subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getThirdCategory() {
		return this.thirdCategory;
	}

	public void setThirdCategory(String thirdCategory) {
		this.thirdCategory = thirdCategory;
	}

}