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
	
	@Column(name = "website", nullable=true)
	private String website;
	
	@Column(name = "facebookpage", nullable=true)
	private String facebookPage;
	
	@Column(name = "phone", nullable=true)
	private String phone;
	
	@Column(name = "address", nullable=false)
	private String address;
	
	@Column(name = "city", nullable=false)
	private String city;
	
	@Column(name = "state", nullable=false)
	private String state;
	
	@Column(name = "zip", nullable=false)
	private String zip;
	
	@Column(name = "latitude", nullable=false)
	private double latitude;
	
	@Column(name = "longitude", nullable=false)
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
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFacebookPage() {
		return facebookPage;
	}

	public void setFacebookPage(String facebookPage) {
		this.facebookPage = facebookPage;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
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

//	public List<ShopReview> getShopReviews() {
//		return shopReviews;
//	}
//
//	public void setShopReviews(List<ShopReview> shopReviews) {
//		this.shopReviews = shopReviews;
//	}

}