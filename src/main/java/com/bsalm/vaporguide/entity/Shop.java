package com.bsalm.vaporguide.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;
	
	@OneToMany(mappedBy="shop_id", fetch=FetchType.LAZY, orphanRemoval=true) 
	private List<ShopReview> shopReviews;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public List<ShopReview> getShopReviews() {
		return shopReviews;
	}

	public void setShopReviews(List<ShopReview> shopReviews) {
		this.shopReviews = shopReviews;
	}

}