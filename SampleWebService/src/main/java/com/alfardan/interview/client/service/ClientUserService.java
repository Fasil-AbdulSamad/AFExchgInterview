package com.alfardan.interview.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alfardan.interview.client.modal.ClientResponse;
import com.alfardan.interview.modal.APIResponse;
import com.alfardan.interview.modal.InputRecord;

@Service
public class ClientUserService {

	String uri = "http://localhost:9091";
	public ClientResponse saveInfo(InputRecord data) {
		ClientResponse response = new ClientResponse();
		response.setResponseCode("500");
		response.setResponseDesc("Backend service failed");
		String path = "api/user/save";
		RestTemplate restTemplate = new RestTemplate();
		APIResponse apiResponse = restTemplate.postForObject(uri+"/"+path,data, APIResponse.class);
		if(apiResponse == null) {
			return response;
		}
		if(apiResponse.getResponseCode().equalsIgnoreCase("000")) {
			response.setResponseCode("OK-000");
			response.setResponseDesc("User Data Saved at Backend");
			response.setCustomerName(apiResponse.getCustName());
			response.setCustomerId(apiResponse.getCustId());
			
		}else {
			response.setResponseCode(apiResponse.getResponseCode());
			response.setResponseDesc(apiResponse.getResponseDesc());
		}			
		return response;
	}

	public ClientResponse fetchAllUsers() {
		ClientResponse response = new ClientResponse();
		response.setResponseCode("500");
		response.setResponseDesc("Backend service failed");
		String path = "api/users";
		RestTemplate restTemplate = new RestTemplate();
		APIResponse apiResponse = restTemplate.getForObject(uri+"/"+path, APIResponse.class);
		if(apiResponse == null) {
			return response;
		}
		if(apiResponse.getResponseCode().equalsIgnoreCase("000")) {
			response.setResponseCode("OK-000");
			response.setResponseDesc("All User Data Retrieved from Backend");
			response.setCustomers(apiResponse.getCustomers());
			
			
		}else {
			response.setResponseCode(apiResponse.getResponseCode());
			response.setResponseDesc(apiResponse.getResponseDesc());
		}			
		return response;
	}

}
