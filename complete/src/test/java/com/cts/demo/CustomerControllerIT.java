package com.cts.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Integration Test for CustomerService
 * Path to REST Resource, CustomerBO : /customerservice
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/customerservice/customer");
    }

    /**
     * Integration Test for CustomerService, getCustomer
     * Path to REST Resource, CustomerBO : /customerservice/customer/{customerId}
     * 
     */
    @Test
    public void getCustomer() throws Exception {
    	String testUrl = base+"/1";
        ResponseEntity<String> response = template.getForEntity(testUrl.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("{\"customerID\":1,\"name\":\"John\",\"acctNo\":0,\"address\":null,\"city\":null,\"state\":null,\"zip\":null,\"lob\":null}"));
    }
    
    /**
     * Integration Test for CustomerService, getCustomer (negative Scenario)
     * Path to REST Resource, CustomerBO : /customerservice/customer/{customerId}
     * 
     */
    @Test
    public void getCustomerNegative() throws Exception {
    	String testUrl = base+"/11";
        ResponseEntity<String> response = template.getForEntity(testUrl.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("{\"errorCode\":\"100\",\"errorMessage\":\"Customer Not Found\"}"));
    }
}
