package com.spring.boot.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.login.modal.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	public User findByUsernameAndPassword(String username, String password);

}
