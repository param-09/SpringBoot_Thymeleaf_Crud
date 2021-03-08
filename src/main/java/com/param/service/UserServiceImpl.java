package com.param.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.param.model.User;
import com.param.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getAllUsers() {

		return userRepository.findAll();
	}
	@Override
	public void saveUser(User user) 
	{
		this.userRepository.save(user);
	}
	@Override
	public User getUserById(Long id) {
		Optional<User> optional =userRepository.findById(id);
		User user=null;
		if(optional.isPresent())
		{
			user=optional.get();
		}
		else
		{
			throw new RuntimeException("User Not Found for Id :" +id);
		}
		return user;
	
	}
	@Override
	public void deleteUserById(long id) 
	{
	   this.userRepository.deleteById(id);	
	}

}
