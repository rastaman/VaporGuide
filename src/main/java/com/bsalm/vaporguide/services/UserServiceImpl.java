package com.bsalm.vaporguide.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bsalm.vaporguide.entity.User;
import com.bsalm.vaporguide.exceptions.UserNotFoundException;
import com.bsalm.vaporguide.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserRepository userRepository;

	@Transactional
	public User create(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}
	
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional
	public User findById(int id) {
		return userRepository.findOne(id);
	}
	
	@Transactional
	public User findByFacebookId(String facebookId) {
		return userRepository.findByFacebookId(facebookId);
	}

	@Transactional(rollbackFor=UserNotFoundException.class)
	public User delete(int id) throws UserNotFoundException 
	{
		User deletedUser = userRepository.findOne(id);
		
		if (deletedUser == null)
			throw new UserNotFoundException();
		
		userRepository.delete(deletedUser);
		return deletedUser;
	}

	@Transactional(rollbackFor=UserNotFoundException.class)
	public User update(User user) throws UserNotFoundException 
	{
		User updatedUser = userRepository.findOne(user.getId());
		
		if (updatedUser == null)
			throw new UserNotFoundException();
		
		//set fields
		
		userRepository.save(updatedUser);
		
		return updatedUser;
	}
	
}
