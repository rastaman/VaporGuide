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
	private Integer id;
	
	@Column(name="googlePlaceId", nullable=true)
	private String googlePlaceId;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name = "address", nullable=false)
	private String address;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;
	
	@OneToMany(mappedBy="shop_id", fetch=FetchType.EAGER, orphanRemoval=true) 
	private List<ShopReview> shopReviews;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGooglePlaceId() {
		return googlePlaceId;
	}

	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public List<ShopReview> getShopReviews() {
		return shopReviews;
	}

	public void setShopReviews(List<ShopReview> shopReviews) {
		this.shopReviews = shopReviews;
	}

}