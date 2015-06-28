package com.bsalm.vaporguide.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userfacebook")
public class UserFacebook implements Serializable {

	// identifiers - facebook id
	@Id
	@Column(name = "id")
	private Integer id;
	
	//fields from facebook
	@Column(name = "name")
	private String name;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "verified")
	private String verified;
	
	//facebook picture
	@Column(name = "is_silhouette")
	private String is_silhouette;
	
	@Column(name = "url")
	private String url;

}