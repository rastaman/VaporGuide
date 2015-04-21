package com.bsalm.vaporguide.entity;

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
@Table(name = "hardwarereview")
public class HardwareReview {

	// identifiers 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	// parent tables
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hardware_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Hardware hardware;

	@Column(name = "hardware_id")
	private int hardware_id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@Column(name = "user_id")
	private int user_id;

	// rating fields 
	@Column(name = "overall_rating")
	private int OverallRating;
	
	@Column(name = "machine_quality")
	private int MachineQuality;
	
	@Column(name = "materials_quality")
	private int MaterialsQuality;
	
	//info fields	
	@Column(name = "ownership_duration")
	private int OwnershipDuration;


}
