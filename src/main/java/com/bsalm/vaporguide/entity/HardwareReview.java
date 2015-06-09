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
	private Integer id;

	// parent tables
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="hardware_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Hardware hardware;

	@Column(name = "hardware_id")
	private Integer hardware_id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@Column(name = "user_id")
	private Integer user_id;

	// rating fields 
	@Column(name = "overall_rating")
	private Integer OverallRating;
	
	@Column(name = "machine_quality")
	private Integer MachineQuality;
	
	@Column(name = "materials_quality")
	private Integer MaterialsQuality;
	
	@Column(name = "design_quality")
	private Integer DesignQuality;
	
	//info fields	
	@Column(name = "ownership_duration")
	private Integer OwnershipDuration;


}
