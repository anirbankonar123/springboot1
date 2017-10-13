package com.cts.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Obtains Customer information based on Customer ID
 * Path to REST Resource, CustomerBO : /customerservice/customer/{customerId}
 * 
 */
@RestController
@RequestMapping("/customerservice")
public class CustomerController {
    
   /**
	   * Gets CustomerBO with the given customerID.
   */
   @RequestMapping(method = RequestMethod.GET,value = "/customer/{customerId}")
   public CustomerBO getCustomer(@PathVariable String customerId) {
	   CustomerBO customerBO = new CustomerBO();
	   //obtain CustomerBO from Database Service
	   customerBO.setName("TEST CUSTOMER WB");
	   customerBO.setCustomerID(111L);
	   return customerBO;

   }
    
}

