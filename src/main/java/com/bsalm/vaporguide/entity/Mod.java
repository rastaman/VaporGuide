package com.bsalm.vaporguide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mods")
public class Mod extends Hardware{

	//fields
	@Column(name = "style")
	private String style;
	
	@Column(name = "temp_control")
	private boolean tempControl;
	
	@Column(name = "hybrid")
	private boolean hybrid;
	
//	@Column(name = "combo")
//	private String combo;
	
	@Column(name = "batteryType")
	private String batteryType;
	
	@Column(name = "max_wattage")
	private Integer maxWattage;
	
	@Column(name = "min_wattage")
	private Integer minWattage;
	
	@Column(name = "width")
	private Integer width;
	
	@Column(name = "height")
	private Integer height;
	
	@Column(name = "depth")
	private String depth;


}
