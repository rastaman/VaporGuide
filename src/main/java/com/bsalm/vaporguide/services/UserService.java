package com.bsalm.vaporguide.services;

import java.util.List;
import com.bsalm.vaporguide.entity.User;
import com.bsalm.vaporguide.exceptions.UserNotFoundException;


public interface UserService {
	
	/////////////////
	// Simple CRUD //
	////////////////
	
	//Searches 
	public List<User> findAll();
	
	public User findById(int id);
	
	public User findByFacebookId(String facebookId);
	
	//Creates
	public User create(User user);
	
	//Updates
	public User update(User user) throws UserNotFoundException;
	
	//Deletes
	public User delete(int id) throws UserNotFoundException;
	

}