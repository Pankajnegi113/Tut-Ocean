package com.spring.boot.login.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.boot.login.modal.Videos;


public interface VideoRepository extends CrudRepository<Videos, Integer> {
	

}
