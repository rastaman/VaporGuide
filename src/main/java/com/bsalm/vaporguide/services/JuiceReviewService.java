package com.bsalm.vaporguide.services;

import java.util.List;

import com.bsalm.vaporguide.entity.JuiceReview;
import com.bsalm.vaporguide.exceptions.JuiceReviewNotFoundException;
public interface JuiceReviewService {
	
	/////////////////
	// Simple CRUD //
	////////////////
	
	//Searches 
	public List<JuiceReview> findAll();
	
	public JuiceReview findById(int id);
	
	public List<JuiceReview> findByJuiceId(int id);
	
	public List<JuiceReview> findByUserId(int id);
	
	public List<JuiceReview> findByUserIdAndJuiceId(int userId, int juiceId);
	
	//Creates
	
	public JuiceReview create(JuiceReview juiceReview) throws JuiceReviewNotFoundException;
	
	//Updates
	
	public JuiceReview update(JuiceReview juiceReview) throws JuiceReviewNotFoundException;
	
	//Deletes
	
	public JuiceReview delete(int id) throws JuiceReviewNotFoundException;
	

}