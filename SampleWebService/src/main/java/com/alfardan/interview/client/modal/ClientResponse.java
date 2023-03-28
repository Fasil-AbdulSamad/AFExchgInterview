package com.alfardan.interview.client.modal;

import java.util.List;

import com.alfardan.interview.dto.Customer;
import com.alfardan.interview.modal.BaseResponse;

public class ClientResponse extends BaseResponse{

	private String customerName;
	private String customerId;
	private List<Customer> customers;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	
	
	
	
	
}
