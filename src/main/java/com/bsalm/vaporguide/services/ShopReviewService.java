package com.bsalm.vaporguide.services;

import java.util.List;

import com.bsalm.vaporguide.entity.ShopReview;
import com.bsalm.vaporguide.exceptions.ShopReviewNotFoundException;
public interface ShopReviewService {
	
	/////////////////
	// Simple CRUD //
	////////////////
	
	//Searches 
	public List<ShopReview> findAll();
	
	public ShopReview findById(int id);
	
	public List<ShopReview> findByName(String Name);
	
	//Creates
	
	public ShopReview create(ShopReview shopReview);
	
	//Updates
	
	public ShopReview update(ShopReview shopReview) throws ShopReviewNotFoundException;
	
	//Deletes
	
	public ShopReview delete(int id) throws ShopReviewNotFoundException;
	

}