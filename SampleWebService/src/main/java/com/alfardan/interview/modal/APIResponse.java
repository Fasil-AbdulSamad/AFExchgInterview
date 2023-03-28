package com.alfardan.interview.modal;

import java.util.List;

import com.alfardan.interview.dto.Customer;

public class APIResponse extends BaseResponse{

	private String custName;
	private String custId;
	private List<Customer> customers;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	
	
	
}
