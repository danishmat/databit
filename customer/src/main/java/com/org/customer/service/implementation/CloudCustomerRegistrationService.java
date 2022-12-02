package com.org.customer.service.implementation;

import com.org.customer.dao.CustomerRepository;
import com.org.customer.exception.CustomerNotValidException;
import com.org.customer.model.CustomerRegistrationRequest;
import com.org.customer.service.CustomerNotificationService;
import com.org.customer.service.CustomerRegistrationService;
import com.org.customer.service.CustomerVerificationService;
import com.org.customer.util.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.org.customer.model.Customer;

@Service
@AllArgsConstructor
@Slf4j
public class CloudCustomerRegistrationService implements CustomerRegistrationService {

    private final CustomerRepository customerRepository;
    private final Customer customer;
    private final CustomerVerificationService customerVerificationService;
    private final CustomerNotificationService customerNotificationService;

    @Override
    public Customer registerCustomer(CustomerRegistrationRequest registrationRequest) {
        log.info("Setting customer from request ...");
        setCustomerRegistration(registrationRequest);
        verifyCustomer();
        saveCustomerRegistration(customer);
        sendRegistrationNotification(customer);
        customer.setRegistered(true);
        return customer;
    }

    @Override
    public void verifyCustomer() {
        log.info("Verifying customer is fraud or not ...");
        Boolean isFraudulent;
        isFraudulent= customerVerificationService.isFraudulentCustomer(customer.getUserName());
        if(isFraudulent)
            throw new CustomerNotValidException(Constants.CUSTOMER_NOT_VALID, Constants.ERROR_2411);
    }

    @Override
    public void sendRegistrationNotification(Customer customer) {
        log.info("Sending notifications after successful registration...");
        customerNotificationService.sendNotifications(customer);
    }

    @Override
    public void saveCustomerRegistration(Customer customer) {
        log.info("Saving customer details ...");
        customerRepository.saveAndFlush(customer);
    }
    public void setCustomerRegistration(CustomerRegistrationRequest registrationRequest) {
        customer.setUserName(registrationRequest.userName());
        customer.setFirstName(registrationRequest.firstName());
        customer.setLastName(registrationRequest.lastName());
        customer.setEmail(registrationRequest.email());
    }
}
