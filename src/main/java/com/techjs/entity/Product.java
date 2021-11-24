package com.techjs.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product 
{
	@Id
	private int pId;
	private String pName;
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	private List<Variant> variant = new ArrayList<Variant>();

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public List<Variant> getVariant() {
		return variant;
	}

	public void setVariant(List<Variant> variant) {
		this.variant = variant;
	}

}
