package com.spring.boot.login.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.login.modal.User;
import com.spring.boot.login.modal.Videos;
import com.spring.boot.login.repository.UserRepository;
import com.spring.boot.login.repository.VideoRepository;

@Service
@Transactional
public class VideoService {
	
	@Autowired
	VideoRepository videoRepository;
	
	@Autowired
	UserRepository userRepository;

	public void saveVideo(Integer id, Videos video) {
		
		User user=userRepository.findById(id).orElse(null);
		if(user!=null)
		{
			user.getVideos().add(video);
			userRepository.save(user);
			//videoRepository.save(video);
		}
		
	}

	public Set<Videos> findVideosById(Integer id) {
		User user=userRepository.findById(id).orElse(null);
		Set<Videos> video = user.getVideos();
		return video;
		
		
	}

}
