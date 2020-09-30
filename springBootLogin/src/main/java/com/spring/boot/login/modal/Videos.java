package com.spring.boot.login.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "videos")
public class Videos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "videoName")
	private String videoName;
	
	@Column(name = "iFrame")
	private String iFrame;
	
    @ManyToMany(mappedBy = "videos", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<>();
	
	Videos(){
		
	}
	
	public Videos(Integer id, String videoName, String iFrame, Set<User> users) {
		super();
		this.id = id;
		this.videoName = videoName;
		this.iFrame = iFrame;
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getiFrame() {
		return iFrame;
	}

	public void setiFrame(String iFrame) {
		this.iFrame = iFrame;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}



}
