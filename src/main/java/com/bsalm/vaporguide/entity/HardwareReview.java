package com.bsalm.vaporguide.entity;

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
import org.joda.time.DateTime;

@Entity
@Table(name = "hardwarereview", 
	indexes = {
        @Index(columnList = "hardware_id", name = "hardwarereview_hardwareid_idx")
  	}, 
  	uniqueConstraints = {
		@UniqueConstraint(columnNames={"hardware_id", "user_id"})
	}
)
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
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "review", columnDefinition="NVARCHAR(1024)")
	private String review;
	
	@Column(name = "build_quality")
	private Integer buildQuality;
	
	@Column(name = "materials_quality")
	private Integer materialsQuality;
	
	@Column(name = "design_quality")
	private Integer designQuality;
	
	//info fields	
	@Column(name = "ownership_duration")
	private Integer ownershipDuration;
	
	//record keeping
	@Basic(optional=false)
	@Column(name="updated_datetime", columnDefinition="DATETIME(3) NOT NULL")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedDate;


}
