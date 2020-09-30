package com.spring.boot.login.controller;

import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.boot.login.modal.User;
import com.spring.boot.login.modal.Videos;
import com.spring.boot.login.service.UserService;
import com.spring.boot.login.service.VideoService;

@Controller
@SessionAttributes("logInUser")
public class VideoController {

	
	@Autowired
	private VideoService videoService;
	
	
//	@GetMapping("/find-user-videos") 
//	public String findVideosById()
//	{
//		Set<Videos>res = videoService.findVideosById(1);
//		return "homePage";
//		
//	}
	
	
	//Method for saving user videos
	@RequestMapping(value="/save-video", method=RequestMethod.POST)
	public String saveVideo(@ModelAttribute Videos video,Model model,HttpSession session)
	{
		User user= (User) session.getAttribute("logInUser");
		videoService.saveVideo(user.getId(),video);
		
		Set<Videos>set= videoService.findVideosById(user.getId());
		model.addAttribute("videoSet", set);
		return "homePage";
	}

}
