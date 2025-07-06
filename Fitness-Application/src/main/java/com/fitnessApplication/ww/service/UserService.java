package com.fitnessApplication.ww.service;

import java.util.List;

import com.fitnessApplication.ww.entity.User;

public interface UserService {

	User createUser(User user);
	User getUserById(Integer id);
	List<User> getAllUsers();
	User updateUser(Integer id, User userDetails);
	void deleteUser(Integer id);
}
