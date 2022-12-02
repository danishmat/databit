package com.org.customer.service;

import com.org.customer.model.CustomerRegistrationRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceTest {
    @Autowired
    private CustomerRegistrationService customerService;

    private CustomerRegistrationRequest customerRegistrationRequest;
    @BeforeEach
    void setUp() {
         customerRegistrationRequest = new CustomerRegistrationRequest("oggadmin",
                "Danish",
                "Mathew",
                "danish@gmail.com");

    }
@Test
void isCustomerRegistered() {
  customerService.registerCustomer(customerRegistrationRequest);
    //assertTrue(isRegistered);
}
    @AfterEach
    void tearDown() {
    }
}