package com.bsalm.vaporguide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "modreview")
public class ModReview extends HardwareReview{

	//fields
	@Column(name = "type")
	private String type;
	
	@Column(name = "ergonomics")
	private int ergonomics;
	
	@Column(name = "battery_life")
	private int batteryLife;

}