package com.bsalm.vaporguide.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "juice", indexes = {
        @Index(columnList = "id", name = "juice_id_idx"),
})
@Inheritance(strategy = InheritanceType.JOINED)
public class Juice {

	// identifier
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	// parent tables
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="brand_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Brand brand;
	
	@Column
	private Integer brand_id;
	
	// referencing tables
	@OneToMany(mappedBy="juice", fetch=FetchType.LAZY, orphanRemoval=true) 
	private List<JuiceReview> juiceReviews;
	
	//fields
	@Column(name = "name")
	private String name;

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

//	public Brand getBrand() {
//		return brand;
//	}
//
//	public void setBrand(Brand brand) {
//		this.brand = brand;
//	}

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

//	public List<JuiceReview> getJuiceReviews() {
//		return juiceReviews;
//	}
//
//	public void setJuiceReviews(List<JuiceReview> juiceReviews) {
//		this.juiceReviews = juiceReviews;
//	}
}