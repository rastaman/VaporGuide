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
@Table(name = "user")
public class User implements Serializable {

	// identifiers
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", unique=true)
	private String name;
	
	@Column(name = "facebookId", unique=true)
	private String facebookId;
	
	@Column(name = "currentFacebookToken", unique=true)
	private String currentFacebookToken;
	
	// referencing tables
	@OneToMany(mappedBy="user_id", fetch=FetchType.LAZY, orphanRemoval=true) 
	private List<ShopReview> shopReviews;
	
	@OneToMany(mappedBy="user_id", fetch=FetchType.LAZY, orphanRemoval=true) 
	private List<ShopReview> hardwareReviews;
	
	@OneToMany(mappedBy="user_id", fetch=FetchType.LAZY, orphanRemoval=true) 
	private List<ShopReview> juiceReviews;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	public List<ShopReview> getShopReviews() {
//		return shopReviews;
//	}
//
//	public void setShopReviews(List<ShopReview> shopReviews) {
//		this.shopReviews = shopReviews;
//	}
//
//	public List<ShopReview> getHardwareReviews() {
//		return hardwareReviews;
//	}
//
//	public void setHardwareReviews(List<ShopReview> hardwareReviews) {
//		this.hardwareReviews = hardwareReviews;
//	}
//
//	public List<ShopReview> getJuiceReviews() {
//		return juiceReviews;
//	}
//
//	public void setJuiceReviews(List<ShopReview> juiceReviews) {
//		this.juiceReviews = juiceReviews;
//	}
}