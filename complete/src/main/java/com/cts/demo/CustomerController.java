package com.cts.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/customerservice")
public class CustomerController {
    
	
   @RequestMapping(method = RequestMethod.GET,value = "/{customerId}")
 
   public CustomerBO getCustomer(@PathVariable String customerId) {
	   CustomerBO customerBO = new CustomerBO();
	   customerBO.setName("TEST CUSTOMER WB");
	   customerBO.setCustomerID(111L);
	   return customerBO;

   }
    
}

