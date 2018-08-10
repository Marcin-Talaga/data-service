package com.example.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dataservice.entity.User;
import com.example.dataservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DataController {
	
	@Autowired
	UserRepository userRepository;
	

	@RequestMapping(method = RequestMethod.GET, path = "/data/{userName}", produces="application/json")
	public ResponseEntity<String> getUserData(@PathVariable(value = "userName") String userName) {
		
		User user = userRepository.findUserByUserName(userName);
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		try {
			json = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		if(user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(json, HttpStatus.OK);
		
	}
	
	

}
