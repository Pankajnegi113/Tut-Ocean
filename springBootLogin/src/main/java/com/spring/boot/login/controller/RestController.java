package com.spring.boot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.boot.login.modal.User;
import com.spring.boot.login.service.UserService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String hello()
	{
		return "Hello home";
	}
	
	@GetMapping("/save-user")
	public String saveUser(@RequestParam String username,@RequestParam String firstname,@RequestParam String lastname
			,@RequestParam String password,@RequestParam int age )
	{

		 //User user= new User(username,firstname,lastname,password,age);
		 //userService.saveMyUser(user);
		 return "user-saved";
	}
	

}
