package com.bsalm.vaporguide.services;

import java.util.List;

import com.bsalm.vaporguide.entity.JuiceReview;
import com.bsalm.vaporguide.entity.ShopReview;
import com.bsalm.vaporguide.exceptions.ShopReviewNotFoundException;
public interface ShopReviewService {
	
	/////////////////
	// Simple CRUD //
	////////////////
	
	//Searches 
	public List<ShopReview> findAll();
	
	public ShopReview findById(int id);
	
	public List<ShopReview> findByShopId(int shop_id);
	
	public List<ShopReview> findByUserId(int id);
	
	public List<ShopReview> findByUserIdAndShopId(int userId, int shopId);
	
	//Creates
	
	public ShopReview create(ShopReview shopReview) throws ShopReviewNotFoundException;
	
	//Updates
	
	public ShopReview update(ShopReview shopReview) throws ShopReviewNotFoundException;
	
	//Deletes
	
	public ShopReview delete(int id) throws ShopReviewNotFoundException;
	

}