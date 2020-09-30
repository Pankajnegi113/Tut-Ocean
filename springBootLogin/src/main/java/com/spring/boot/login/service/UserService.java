package com.spring.boot.login.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.login.modal.User;
import com.spring.boot.login.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void saveMyUser(User user)
	{
		userRepository.save(user);
	}
	
	public List<User> showAllUsers()
	{
		List<User>users=new ArrayList<>();
		for(User user: userRepository.findAll())
		{
			users.add(user);
		}
		return users;
	}

	
	public void deleteMyUser(int id) {
		userRepository.deleteById(id);
	}

	public User editUser(int id) {
		
		return userRepository.findById(id).orElse(null);	
	
	}

	public User findByUsernameAndPassword(String username, String password) {
		
		return userRepository.findByUsernameAndPassword(username,password);
	}

}
