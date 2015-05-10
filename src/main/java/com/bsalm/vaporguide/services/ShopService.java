package com.bsalm.vaporguide.services;

import java.util.List;

import com.bsalm.vaporguide.entity.Shop;
import com.bsalm.vaporguide.exceptions.ShopNotFoundException;
public interface ShopService {
	
	/////////////////
	// Simple CRUD //
	////////////////
	
	//Searches 
	public List<Shop> findAll();
	
	public Shop findById(int id);
	
	public List<Shop> findByName(String Name);
	
	//Creates
	
	public Shop create(Shop shop);
	
	//Updates
	
	public Shop update(Shop shop) throws ShopNotFoundException;
	
	//Deletes
	
	public Shop delete(int id) throws ShopNotFoundException;
	

}