package com.alfardan.interview.dao;

import org.springframework.data.repository.CrudRepository;

import com.alfardan.interview.dto.Customer;


public interface CustomerRespository extends CrudRepository<Customer, Long> {

	
}
