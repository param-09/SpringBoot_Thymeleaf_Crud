package com.param.service;

import java.util.List;

import com.param.model.User;

public interface UserService 
{
	List<User> getAllUsers();

	void saveUser(User user);

	User getUserById(Long id);
	
	void deleteUserById(long id);
}
