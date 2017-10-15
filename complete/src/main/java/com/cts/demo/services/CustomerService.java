package com.cts.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.cts.demo.domain.CustomerBO;

@Service
public class CustomerService {
	
	private final List<CustomerBO> customers = new ArrayList<>();
	
	@PostConstruct
	public void init() {
		customers.add(new CustomerBO(1l,"John"));
		customers.add(new CustomerBO(2l,"Dave"));
		customers.add(new CustomerBO(3l,"Anirban"));
		customers.add(new CustomerBO(4l,"Jeevan"));
		
	}
	
	public CustomerBO getById(long custId){
		
		return customers.stream().filter((customerBO) -> customerBO.getCustomerID() == custId).findFirst().get();
		
	}
	
	public String saveCustomer(CustomerBO customerBO){
		
		customers.add(customerBO);
		return String.valueOf(customerBO.getCustomerID());
		
	}

}
