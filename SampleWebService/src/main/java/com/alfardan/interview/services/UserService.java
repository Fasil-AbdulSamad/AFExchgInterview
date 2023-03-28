package com.alfardan.interview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alfardan.interview.dao.CustomerRespository;
import com.alfardan.interview.dto.Customer;
import com.alfardan.interview.modal.APIResponse;
import com.alfardan.interview.modal.InputRecord;

@Service
public class UserService {
	@Autowired
	CustomerRespository customerRespository;
	
	public APIResponse saveInfo(InputRecord data) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setResponseCode("400");
		apiResponse.setResponseDesc("Invalid Request");
		if(data == null)
			return apiResponse;
		
		if(data.getCustName() == null || data.getCustName().isEmpty()) {
			apiResponse.setResponseDesc("Invalid Request.Customer name is null or empty");
			return apiResponse;
		}else {
			Customer customer = new Customer();
			customer.setCustomerName(data.getCustName());
			Customer custData = customerRespository.save(customer);
			
			if(custData != null && custData.getCustomerId() > 0) {
				apiResponse.setResponseCode("000");
				apiResponse.setResponseDesc("Data Saved Successfully");
				apiResponse.setCustName(custData.getCustomerName());
				apiResponse.setCustId(String.valueOf(custData.getCustomerId()));
			}else {
				apiResponse.setResponseCode("500");
				apiResponse.setResponseDesc("Could not save your data");
			}
		}
		return apiResponse;
	}

	public APIResponse fetchAllUsers() {
		List<Customer> customers = (List<Customer>) customerRespository.findAll();
		APIResponse response = new APIResponse();
		if(customers != null && !customers.isEmpty()) {
			response.setResponseCode("000");
			response.setResponseDesc("Success");
			response.setCustomers(customers);
		}else {
			response.setResponseCode("500");
			response.setResponseDesc("No User Data Found");
		}
		return response;
	}

}
