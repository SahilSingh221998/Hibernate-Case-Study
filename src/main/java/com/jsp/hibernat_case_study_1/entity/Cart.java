package com.jsp.hibernat_case_study_1.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

@Entity
public class Cart {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int cartId;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<Product> products=new ArrayList<Product>();
	public int getCartId() {
		return cartId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}




}
