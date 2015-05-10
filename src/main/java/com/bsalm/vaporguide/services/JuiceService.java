package com.bsalm.vaporguide.services;

import java.util.List;

import com.bsalm.vaporguide.entity.Juice;
import com.bsalm.vaporguide.exceptions.JuiceNotFoundException;
public interface JuiceService {
	
	/////////////////
	// Simple CRUD //
	////////////////
	
	//Searches 
	public List<Juice> findAll();
	
	public Juice findById(int id);
	
	public List<Juice> findByName(String Name);
	
	//Creates
	
	public Juice create(Juice juice);
	
	//Updates
	
	public Juice update(Juice juice) throws JuiceNotFoundException;
	
	//Deletes
	
	public Juice delete(int id) throws JuiceNotFoundException;
	

}