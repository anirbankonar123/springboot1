package com.cts.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cts.demo.controller.CustomerController;
import com.cts.demo.domain.CustomerBO;
import com.cts.demo.exception.ResourceNotFoundException;

@Service
public class CustomerService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
	
	private final List<CustomerBO> customers = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		customers.add(new CustomerBO(1l,"John"));
		customers.add(new CustomerBO(2l,"Dave"));
		customers.add(new CustomerBO(3l,"Anirban"));
		customers.add(new CustomerBO(4l,"Jeevan"));
		
	}
	
	public CustomerBO getById(long custId){
		CustomerBO custBO = new CustomerBO();
		try{
			custBO = customers.stream().filter((customerBO) -> customerBO.getCustomerID() == custId).findFirst().get();
		}catch(Exception exc){
			 log.info("throwing exc from Service layer");
			 throw new ResourceNotFoundException(custId,"Customer Not Found"); 
		}
		return custBO;
	}
	
	public String saveCustomer(CustomerBO customerBO){
		
		customers.add(customerBO);
		return String.valueOf(customerBO.getCustomerID());
		
	}

}
