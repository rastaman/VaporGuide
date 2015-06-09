package com.bsalm.vaporguide.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "juiceflavor")
@Inheritance(strategy = InheritanceType.JOINED)
public class JuiceFlavor {

	// identifier
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

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

}