package com.spring.boot.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.boot.login.modal.User;
import com.spring.boot.login.service.UserService;
import com.spring.boot.login.service.VideoService;

@Controller
@SessionAttributes("logInUser")
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VideoService videoService;
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request)
	{
		request.setAttribute("mode", "MODE_HOME");
		return "welcomePage";
		
	}
	
	//redirecting to register section
	@RequestMapping("/register")
	public String registration(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcomePage";
	}
	
	
	//redirecting to save-user section of welcomePage
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("mode", "MODE_HOME");
		return "welcomePage";
	}
	
	//show all users
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "welcomePage";
	}
	
	//delete a user from database
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		return "redirect:/show-users";
	}
	
	//edit users details
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "welcomePage";
	}
	

	//redirect to login section of welcomepage
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcomePage";
	}
	
	//user logging in , after successfull login, redirect to homePage of user
	@PostMapping ("/login-user")
	public String loginUser(@ModelAttribute User user, Model model,HttpSession session) {
		User currentUser = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if(currentUser !=null) {
			model.addAttribute("logInUser", currentUser);
			session.setAttribute("logInUser", currentUser);
			model.addAttribute("videoSet", videoService.findVideosById(currentUser.getId()));
			return "homePage";
		}
		else {
			model.addAttribute("error", "Invalid Username or Password");
			model.addAttribute("mode", "MODE_LOGIN");
			return "welcomePage";
			
		}
	}
	
	

}
