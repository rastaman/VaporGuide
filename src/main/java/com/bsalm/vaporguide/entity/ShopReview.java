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

@Entity
@Table(name = "shopreview")
public class ShopReview implements Serializable 
{

	// identifiers 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	// parent tables
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shop_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Shop shop;
	
	@Column(name = "shop_id")
	private int shop_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@Column(name = "user_id")
	private int user_id;
	
	// fields 
	@Column(name = "atmosphere")
	private int atmosphereRating;

	@Column(name = "staff")
	private int staffRating;
	
	@Column(name = "stock")
	private int stockRating;
	
	
	//getters & setters 
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
	
	public int getArtist_id() {
		return shop_id;
	}

	public void setArtist_id(int shop_id) {
		this.shop_id = shop_id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_id() {
		return user_id;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getAtmosphereRating() {
		return atmosphereRating;
	}

	public void setAtmosphereRating(int atmosphereRating) {
		this.atmosphereRating = atmosphereRating;
	}

	public int getStaffRating() {
		return staffRating;
	}

	public void setStaffRating(int staffRating) {
		this.staffRating = staffRating;
	}

	public int getStockRating() {
		return stockRating;
	}

	public void setStockRating(int stockRating) {
		this.stockRating = stockRating;
	}
}
	
