package com.cts.demo.controller;

import org.springframework.web.bind.annotation.RestController;


import com.cts.demo.domain.CustomerBO;
import com.cts.demo.exception.ResourceNotFoundException;
import com.cts.demo.services.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import javax.inject.Inject;


/**
 * Obtains Customer information based on Customer ID
 * Path to REST Resource, CustomerBO : /customerservice/customer/{customerId}
 * 
 */
@RestController
@RequestMapping("/customerservice")
public class CustomerController {
    
   private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
   
   @Inject
   private CustomerService customerService;
   
   /**
	   * Gets CustomerBO with the given customerID.
   */
   @RequestMapping(method = RequestMethod.GET,value = "/customer/{customerId}")
   public CustomerBO getCustomer(@PathVariable String customerId) {
	   Long custId = Long.parseLong(customerId);
	   CustomerBO customerBO = customerService.getById(custId);
	   return customerBO;
   }
   
   /**
	   * Saves CustomerBO.
   */
   @RequestMapping(method = RequestMethod.POST,value = "/customer/")
   public @ResponseBody CustomerBO saveCustomer(@RequestBody CustomerBO customerBO) {
	   customerService.saveCustomer(customerBO);
	   return customerBO;
   } 
  
    	
}

