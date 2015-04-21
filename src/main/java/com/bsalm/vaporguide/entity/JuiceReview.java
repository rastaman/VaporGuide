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
@Table(name = "juicereview")
public class JuiceReview 
{
	
	//TODO : add constraint for one review per product per user 
	
	// identifiers 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	// parent tables
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="juice_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Juice juice;

	@Column(name = "juice_id")
	private int juice_id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	@Column(name = "user_id")
	private int user_id;

	//rating
	@Column(name = "rating")
	private int rating;
	
	@Column(name = "review")
	private String review;
	
	@Column(name = "flavor")
	private int flavor;
	
	@Column(name = "vapor")
	private int vapor;
	
	@Column(name = "throat")
	private int throat;
	
	@Column(name = "worth")
	private int worth;
	
	//preferences
	@Column(name = "vg")
	private int vg;
	
	@Column(name = "pg")
	private int pg;
	
	@Column(name = "nic")
	private int nic;
	
	@Column(name = "steep")
	private int steep;
	
	// flavor characteristics 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="flavor_one", referencedColumnName = "id", insertable = false, updatable = false)
	private JuiceFlavor flavorOne;
	
	@Column
	private int flavor_one;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="flavor_two", referencedColumnName = "id", insertable = false, updatable = false)
	private JuiceFlavor flavorTwo;
	
	@Column
	private int flavor_two;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="flavor_three", referencedColumnName = "id", insertable = false, updatable = false)
	private JuiceFlavor flavorThree; 
	
	@Column
	private int flavor_three;
	
	//getters / setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Juice getJuice() {
		return juice;
	}

	public void setJuice(Juice juice) {
		this.juice = juice;
	}

	public int getJuice_id() {
		return juice_id;
	}

	public void setJuice_id(int juice_id) {
		this.juice_id = juice_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getFlavor() {
		return flavor;
	}

	public void setFlavor(int flavor) {
		this.flavor = flavor;
	}

	public int getVapor() {
		return vapor;
	}

	public void setVapor(int vapor) {
		this.vapor = vapor;
	}

	public int getThroat() {
		return throat;
	}

	public void setThroat(int throat) {
		this.throat = throat;
	}

	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}

	public int getVg() {
		return vg;
	}

	public void setVg(int vg) {
		this.vg = vg;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getNic() {
		return nic;
	}

	public void setNic(int nic) {
		this.nic = nic;
	}

	public int getSteep() {
		return steep;
	}

	public void setSteep(int steep) {
		this.steep = steep;
	}

	public JuiceFlavor getFlavorOne() {
		return flavorOne;
	}

	public void setFlavorOne(JuiceFlavor flavorOne) {
		this.flavorOne = flavorOne;
	}

	public JuiceFlavor getFlavorTwo() {
		return flavorTwo;
	}

	public void setFlavorTwo(JuiceFlavor flavorTwo) {
		this.flavorTwo = flavorTwo;
	}

	public JuiceFlavor getFlavorThree() {
		return flavorThree;
	}

	public void setFlavorThree(JuiceFlavor flavorThree) {
		this.flavorThree = flavorThree;
	}

}