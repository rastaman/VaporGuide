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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "brand")
public class Brand implements Serializable {

	// identifiers 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	@NotNull
	private String name;
	
	//fields
	@Column(name = "website")
	private String website;
	
	//child tables 
	@OneToMany(mappedBy="brand_id", fetch=FetchType.EAGER, orphanRemoval=true) 
	private List<Hardware> hardware;
	
	@OneToMany(mappedBy="brand_id", fetch=FetchType.EAGER, orphanRemoval=true) 
	private List<Juice> juice;
	
	//getters / setters
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Hardware> getHardware() {
		return hardware;
	}

	public void setHardware(List<Hardware> hardware) {
		this.hardware = hardware;
	}

	public List<Juice> getJuice() {
		return juice;
	}

	public void setJuice(List<Juice> juice) {
		this.juice = juice;
	}	
}