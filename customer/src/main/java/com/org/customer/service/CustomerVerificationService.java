package com.org.customer.service;

import org.springframework.stereotype.Component;

@Component
public interface CustomerVerificationService {
    /**
     * Checking the customer is fraud or not, before registration
     *
     * @param userName
     * @return
     */
    boolean isFraudulentCustomer(String userName);
}
