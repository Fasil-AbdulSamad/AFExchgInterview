package com.alfardan.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alfardan.interview.modal.APIResponse;
import com.alfardan.interview.modal.InputRecord;
import com.alfardan.interview.services.UserService;

/**
 * API MainController 
 * 
 * 
 * **/
@RestController
@RequestMapping("/api")
public class MainController {	
	
	@Autowired
	UserService service;

	
	/**
	 * Save incoming user data from JSON Input
	 * @param InputRecord
	 * @return Success/Error Response
	 */
	@PostMapping
	@RequestMapping("/user/save")
	ResponseEntity<APIResponse> saveData(@RequestBody InputRecord data){
		APIResponse response = service.saveInfo(data);
		return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
		
	}
	
	/**
	 * API to get all users data available
	 */
	@GetMapping
	@RequestMapping("/users")
	ResponseEntity<APIResponse> fetchUsers(){
		APIResponse response = service.fetchAllUsers();
		return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
		
	}
}