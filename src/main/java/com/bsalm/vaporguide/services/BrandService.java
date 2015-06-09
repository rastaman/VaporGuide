package com.bsalm.vaporguide.services;

import java.util.List;

import com.bsalm.vaporguide.entity.Brand;
import com.bsalm.vaporguide.entity.Juice;

public interface BrandService {
	
	/////////////////
	// Simple CRUD //
	////////////////
	
	//Searches 
	public List<Brand> findAll();
	
	public Brand findById(int id);

	public List<Juice> findAllJuice(int i);
	
	//public List<JuiceReview> findByName(String Name);
	
	//Creates
	
	
	
	//Updates
	

	
	//Deletes
	

}