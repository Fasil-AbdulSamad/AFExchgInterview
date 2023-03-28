package com.alfardan.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alfardan.interview.client.modal.ClientResponse;
import com.alfardan.interview.client.service.ClientUserService;
import com.alfardan.interview.modal.InputRecord;

/**
 * Client API Controller 
 * 
 * 
 * **/
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	ClientUserService service;
	
	/**
	 * Client API to save user input data
	 * @param InputRecord
	 * @return ClientResponse
	 */
	@RequestMapping("/user/action/save")
	@PostMapping
	ResponseEntity<ClientResponse> saveData(@RequestBody InputRecord data){
		ClientResponse response = service.saveInfo(data);
		return new ResponseEntity<ClientResponse>(response, HttpStatus.OK);
		
	}
	
	/**
	 * Client API to get all users data in a JSON Format
	 */
	@RequestMapping("/user/list")
	@PostMapping
	ResponseEntity<ClientResponse> findAllUsers(){
		ClientResponse response = service.fetchAllUsers();
		return new ResponseEntity<ClientResponse>(response, HttpStatus.OK);
		
	}
	
	
}
