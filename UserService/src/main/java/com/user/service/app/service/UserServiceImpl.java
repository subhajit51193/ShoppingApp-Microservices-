package com.user.service.app.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.app.entity.User;
import com.user.service.app.exception.UserException;
import com.user.service.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	/*
	 * Register or creating user and saving into database
	 */
	@Override
	public User createUser(User user) throws UserException {
		
		//creating random unique userid
		String randomUserId = UUID.randomUUID().toString();
		
		user.setUserId(randomUserId);
		User newUser =  userRepository.save(user);
		if (newUser != null) {
			return newUser;
		}
		else {
			throw new UserException("Error Occured");
		}
	}

	/*
	 * Getting all users from database
	 */
	@Override
	public List<User> getAllUsers() throws UserException {
		
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new UserException("Empty List");
		}
		else {
			return users;
		}
	}

	
	/*
	 * Get particular user based on userId.  
	 */
	@Override
	public User getUserById(String id) throws UserException {
		
		Optional<User> opt = userRepository.findById(id);
		
		if (opt == null) {
			throw new UserException("Not found");
		}
		else {
			return opt.get();
		}
	}

	/*
	 * Delete User from database
	 */
	@Override
	public User deleteUser(User user) throws UserException {
		
		if (user == null) {
			throw new UserException("Not found");
		}
		else {
			userRepository.delete(user);
			return user;
		}
	}

	
	/*
	 * Update User and save new data into database
	 */
	@Override
	public User updateUser(String userId, User user) throws UserException {
		
		Optional<User> opt = userRepository.findById(userId);
		if (opt.isEmpty()) {
			throw new UserException("User not found");
		}
		else {
			User foundUser = opt.get();
			foundUser.setFirstName(user.getFirstName());
			foundUser.setLastName(user.getLastName());
			foundUser.setContactNo(user.getContactNo());
			return userRepository.save(foundUser);
		}
	}

	
}
