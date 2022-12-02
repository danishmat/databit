package com.org.customer.controller;

import com.org.customer.model.Customer;
import com.org.customer.model.CustomerRegistrationRequest;
import com.org.customer.service.CustomerRegistrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/customers")

public class CustomerRegistrationController {
    private final CustomerRegistrationService customerRegistrationService;

    @PostMapping
    public Customer registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest ) {
        log.info(" New Customer Registration ", customerRegistrationRequest);
        Customer customer = customerRegistrationService.registerCustomer(customerRegistrationRequest);
        return customer;
    }
}
