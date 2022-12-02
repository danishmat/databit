package com.org.customer.dao.implementation.rest;

import com.org.clients.fraud.model.FraudCheckResponse;
import com.org.customer.dao.CustomerDao;
import com.org.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
@Slf4j
public class CustomerRestDao
        implements CustomerDao {
    private final FraudClient fraudClient ;

    @Override
    public Optional send(Object customerName) {
        Boolean isFraud = isFraudulentCustomer((String) customerName);
        return Optional.of(isFraud);
    }

    @Override
    public boolean isFraudulentCustomer(String userName) {
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(userName);
        return fraudCheckResponse.isFraudster();
    }
}
