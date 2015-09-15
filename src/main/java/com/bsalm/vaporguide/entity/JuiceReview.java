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
import org.jadira.usertype.dateandtime.joda.PersistentDateTime;
import org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime;
import org.joda.time.DateTime;

@Entity
@Table(name = "juicereview", 
	indexes = {
        @Index(columnList = "juice_id", name = "juicereview_juiceid_idx")
  	}, 
  	uniqueConstraints = {
		@UniqueConstraint(columnNames={"juice_id", "user_id"})
	}
)
public class JuiceReview 
{
	
	//TODO : add constraint for one review per product per user 
	
	// identifiers 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	// parent tables
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="juice_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Juice juice;
	@Column
	private Integer juice_id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	@Column
	private Integer user_id;

	//rating
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "review", columnDefinition="NVARCHAR(1024)")
	private String review;
	
	@Column(name = "flavor")
	private Integer flavor;
	
	@Column(name = "vapor")
	private Integer vapor;
	
	@Column(name = "throat")
	private Integer throat;
	
	@Column(name = "worth")
	private Integer worth;
	
	//preferences
	@Column(name = "vg", columnDefinition="DECIMAL(3,1) NOT NULL")
	private double vg;
	
	@Column(name = "pg", columnDefinition="DECIMAL(3,1) NOT NULL")
	private double pg;
	
	@Column(name = "nic", columnDefinition="DECIMAL(2,1) NOT NULL")
	private double nic;
	
	@Column(name = "steep", columnDefinition="DECIMAL(3,1) NOT NULL")
	private double steep;
	
	// flavor characteristics 
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="flavorOneId", referencedColumnName = "id", insertable = false, updatable = false)
//	private JuiceFlavor flavorOne;
	
	@Column(nullable=false)
	private Integer flavorOneId;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="flavorTwoId", referencedColumnName = "id", insertable = false, updatable = false)
//	private JuiceFlavor flavorTwo;
	
	@Column(nullable=true)
	private Integer flavorTwoId;
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="flavorThreeId", referencedColumnName = "id", insertable = false, updatable = false)
//	private JuiceFlavor flavorThree; 
	
	@Column(nullable=true)
	private Integer flavorThreeId;
	
	//record keeping
	@Basic(optional=false)
	@Column(name="updated_datetime", columnDefinition="DATETIME(3) NOT NULL")
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime updatedDate;
	
	//getters / setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Juice getJuice() {
//		return juice;
//	}
//
//	public void setJuice(Juice juice) {
//		this.juice = juice;
//	}

	public Integer getJuice_id() {
		return juice_id;
	}

	public void setJuice_id(Integer juice_id) {
		this.juice_id = juice_id;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Integer getFlavor() {
		return flavor;
	}

	public void setFlavor(Integer flavor) {
		this.flavor = flavor;
	}

	public Integer getVapor() {
		return vapor;
	}

	public void setVapor(Integer vapor) {
		this.vapor = vapor;
	}

	public Integer getThroat() {
		return throat;
	}

	public void setThroat(Integer throat) {
		this.throat = throat;
	}

	public Integer getWorth() {
		return worth;
	}

	public void setWorth(Integer worth) {
		this.worth = worth;
	}

	public Double getVg() {
		return vg;
	}

	public void setVg(Double vg) {
		this.vg = vg;
	}

	public Double getPg() {
		return pg;
	}

	public void setPg(Double pg) {
		this.pg = pg;
	}

	public Double getNic() {
		return nic;
	}

	public void setNic(Double nic) {
		this.nic = nic;
	}

	public Double getSteep() {
		return steep;
	}

	public void setSteep(Double steep) {
		this.steep = steep;
	}

	public Integer getFlavorOneId() {
		return flavorOneId;
	}

	public void setFlavorOneId(Integer flavorOneId) {
		this.flavorOneId = flavorOneId;
	}

	public Integer getFlavorTwoId() {
		return flavorTwoId;
	}

	public void setFlavorTwoId(Integer flavorTwoId) {
		this.flavorTwoId = flavorTwoId;
	}

	public Integer getFlavorThreeId() {
		return flavorThreeId;
	}

	public void setFlavorThreeId(Integer flavorThreeId) {
		this.flavorThreeId = flavorThreeId;
	}

//	public JuiceFlavor getFlavorOne() {
//		return flavorOne;
//	}
//
//	public void setFlavorOne(JuiceFlavor flavorOne) {
//		this.flavorOne = flavorOne;
//	}
//
//	public JuiceFlavor getFlavorTwo() {
//		return flavorTwo;
//	}
//
//	public void setFlavorTwo(JuiceFlavor flavorTwo) {
//		this.flavorTwo = flavorTwo;
//	}
//
//	public JuiceFlavor getFlavorThree() {
//		return flavorThree;
//	}
//
//	public void setFlavorThree(JuiceFlavor flavorThree) {
//		this.flavorThree = flavorThree;
//	}
	
	public DateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(DateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

}