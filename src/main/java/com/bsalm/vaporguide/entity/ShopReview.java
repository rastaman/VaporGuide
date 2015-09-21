package com.bsalm.vaporguide.entity;


import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.DateTime;

@Entity
@Table(name = "shopreview", 
	indexes = {
		@Index(columnList = "shop_id", name = "shopreview_shopid_idx")
	}, 
	uniqueConstraints = {
		@UniqueConstraint(columnNames={"shop_id", "user_id"})
	}
)
public class ShopReview implements Serializable 
{
	// identifiers 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
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
	
	@Column(name = "review", columnDefinition="NVARCHAR(4096)")
	private String review;
	
	@Column(name = "atmosphere")
	private Integer atmosphere;

	@Column(name = "staff")
	private Integer staff;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "beginner")
	private Boolean beginner;
	
	@Column(name = "advanced")
	private Boolean advanced;
	
	//record keeping
	@Basic(optional=false)
	@Column(name="updated_datetime", columnDefinition="DATETIME(3) NOT NULL")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedDate;
	
	//getters & setters 
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Boolean getBeginner() {
		return beginner;
	}

	public void setBeginner(Boolean beginner) {
		this.beginner = beginner;
	}

	public Boolean getAdvanced() {
		return advanced;
	}

	public void setAdvanced(Boolean advanced) {
		this.advanced = advanced;
	}

	public Integer getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Integer atmosphere) {
		this.atmosphere = atmosphere;
	}

	public Integer getStaff() {
		return staff;
	}

	public void setStaff(Integer staff) {
		this.staff = staff;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}
	
