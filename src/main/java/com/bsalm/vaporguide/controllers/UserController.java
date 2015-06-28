package com.bsalm.vaporguide.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bsalm.vaporguide.entity.User;
import com.bsalm.vaporguide.exceptions.InvalidRequestException;
import com.bsalm.vaporguide.exceptions.UserNotFoundException;
import com.bsalm.vaporguide.exceptions.ResourceNotFoundException;
import com.bsalm.vaporguide.services.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
//	@Autowired
//	private UserValidator userValidator;
//
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(userValidator);
//	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUserById(@PathVariable Integer id) {
		return userService.findById(id);
	}

	@RequestMapping(value="/facebook/{id}", method=RequestMethod.GET)
	public User getUserByFacebookId(@PathVariable String id) {
		return userService.findByFacebookId(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public User createUser(@ModelAttribute @Valid User user,
			BindingResult result) {

		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error creating user", result);
		
		return userService.create(user);	
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public User editUser(@ModelAttribute User user, @PathVariable Integer id,
			BindingResult result) {
		
		//If there's validation errors
		if (result.hasErrors())
			throw new InvalidRequestException("Error updating user", result);

		//call update service
		User updatedUser;
		try {
			updatedUser = userService.update(user);
		} catch (UserNotFoundException e) {
			throw new ResourceNotFoundException("Unable to update user with ID = "+ id
					+". No such user exists.");
		}

		return updatedUser;
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public User deleteUser(@PathVariable Integer id)
	{	
		//call delete service
		User deletedUser;
		try {
			deletedUser = userService.delete(id);
		} catch (UserNotFoundException e) {
			throw new ResourceNotFoundException("Unable to delete user with ID = "+ id
					+". No such user exists.");
		}

		return deletedUser;
	}

}
