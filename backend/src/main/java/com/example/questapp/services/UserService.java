package com.example.questapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questapp.entities.User;
import com.example.questapp.repos.UserRepository;

@Service
public class UserService {

	UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public User getOneUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}

	public User saveOneUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepository.save(newUser);
	}

	public User updateOneUser(Long userId, User newUser) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUsername(newUser.getUsername());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		} else
			return null;
	}

	public void deleteOneUser(Long userId) {
		userRepository.deleteById(userId);

	}

}
