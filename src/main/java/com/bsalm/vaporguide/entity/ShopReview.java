package com.bsalm.vaporguide.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;

@Entity
@Table(name = "shopreview")
public class ShopReview implements Serializable 
{
	// identifiers 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	// parent tables
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shop_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Shop shop;
	
	@Column(name = "shop_id")
	private Integer shop_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@Column(name = "user_id")
	private Integer user_id;
	
	// fields 
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "atmosphere")
	private Integer atmosphereRating;

	@Column(name = "staff")
	private Integer staffRating;
	
	@Column(name = "stock")
	private Integer stockRating;
	
	//record keeping
	@Column(name = "updated_datetime")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private PersistentLocalDateTime updatedDate;
	
	
	//getters & setters 
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
	
	public Integer getArtist_id() {
		return shop_id;
	}

	public void setArtist_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public Integer getUser_id() {
//		return user_id;
//	}
//	
//	public void setUser_id(Integer user_id) {
//		this.user_id = user_id;
//	}
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getAtmosphereRating() {
		return atmosphereRating;
	}

	public void setAtmosphereRating(Integer atmosphereRating) {
		this.atmosphereRating = atmosphereRating;
	}

	public Integer getStaffRating() {
		return staffRating;
	}

	public void setStaffRating(Integer staffRating) {
		this.staffRating = staffRating;
	}

	public Integer getStockRating() {
		return stockRating;
	}

	public void setStockRating(Integer stockRating) {
		this.stockRating = stockRating;
	}

	public PersistentLocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(PersistentLocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}
	
