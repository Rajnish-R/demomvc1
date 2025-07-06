package com.fitnessApplication.ww.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessApplication.ww.entity.User;
import com.fitnessApplication.ww.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	@Override
	public User getUserById(Integer id)
	{
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@Override
	public User updateUser(Integer id, User userDetails) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			User user = optional.get();
			user.setUsername(userDetails.getUsername());
			user.setAge(userDetails.getAge());
			return userRepository.save(user);
		}
		return null;
	}
	
	@Override
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}

