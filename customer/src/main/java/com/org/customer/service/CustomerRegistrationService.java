package com.org.customer.service;

import com.org.customer.model.Customer;
import com.org.customer.model.CustomerRegistrationRequest;
import org.springframework.stereotype.Component;

/**
 * Responsible for customer services
 */
@Component
public interface CustomerRegistrationService {
    /**
     * Registering the customer
     *
     * @param request
     */
    public Customer registerCustomer(CustomerRegistrationRequest request);

    /**
     *  Sending the notification after successful registration
     * @param customer
     */
    public void sendRegistrationNotification(Customer customer);

    /**
     * Verifying the customer before registration
     */
    public void verifyCustomer();

    /**
     *
     * @param customer
     */
    public void saveCustomerRegistration(Customer customer);
}
