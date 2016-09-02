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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(id);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
		result = prime * result + ((thirdCategory == null) ? 0 : thirdCategory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubThirdCategory other = (SubThirdCategory) obj;
		if (Double.doubleToLongBits(id) != Double.doubleToLongBits(other.id))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (thirdCategory == null) {
			if (other.thirdCategory != null)
				return false;
		} else if (!thirdCategory.equals(other.thirdCategory))
			return false;
		return true;
	}

}