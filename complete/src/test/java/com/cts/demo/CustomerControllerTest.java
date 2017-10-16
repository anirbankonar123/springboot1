package com.cts.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Unit Test for CustomerService
 * Path to REST Resource, CustomerBO : /customerservice/
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;
    /**
     * Unit Test for CustomerService getCustomer
     * Path to REST Resource, CustomerBO : /customerservice/customer/{customerId}
     * 
     */
    @Test
    public void getCustomer() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customerservice/customer/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"customerID\":1,\"name\":\"John\",\"acctNo\":0,\"address\":null,\"city\":null,\"state\":null,\"zip\":null,\"lob\":null}"));
                
    }
    
    /**
     * Unit Test for CustomerService getCustomer (negative scenario)
     * Path to REST Resource, CustomerBO : /customerservice/customer/{customerId}
     * 
     */
    @Test
    public void getCustomerNegative() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/customerservice/customer/11").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().json("{\"errorCode\":\"100\",\"errorMessage\":\"Customer Not Found\"}"));
                
    }
}
