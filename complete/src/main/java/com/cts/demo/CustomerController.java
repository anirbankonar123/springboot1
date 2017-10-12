package com.cts.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Obtains Customer information based on Customer ID
 * 
 */
@RestController
@RequestMapping("/customerservice")
public class CustomerController {
    
   /**
	   * Gets CustomerBO with the given customerID.
   */
   @RequestMapping(method = RequestMethod.GET,value = "/{customerId}")
   public CustomerBO getCustomer(@PathVariable String customerId) {
	   CustomerBO customerBO = new CustomerBO();
	   customerBO.setName("TEST CUSTOMER WB");
	   customerBO.setCustomerID(111L);
	   return customerBO;

   }
    
}

