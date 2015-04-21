package com.bsalm.vaporguide.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "atomizerreview")
public class AtomizerReview extends HardwareReview{

	//fields
	@Column(name = "type")
	private String type;
	
	@Column(name = "flavor")
	private int flavor;
	
	@Column(name = "vapor")
	private int vapor;

}