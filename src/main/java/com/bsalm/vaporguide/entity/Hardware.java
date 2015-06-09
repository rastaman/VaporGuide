package com.bsalm.vaporguide.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hardware")
@Inheritance(strategy = InheritanceType.JOINED)
public class Hardware {

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
	@OneToMany(mappedBy="hardware", fetch=FetchType.LAZY, orphanRemoval=true) 
	private List<HardwareReview> hardwareReviews;
	
	//common fields amongst child tables
	@Column(name = "name")
	private String name;


}
