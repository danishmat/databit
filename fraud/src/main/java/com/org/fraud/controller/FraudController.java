package com.org.fraud.controller;

import com.org.clients.fraud.model.FraudCheckResponse;
import com.org.fraud.service.implementation.MigrationUserVerificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudController {
    private final MigrationUserVerificationService customerVerificationService;

    @GetMapping(path = "{userName}")
    public FraudCheckResponse isFraudster(@PathVariable("userName") String userName) {
        boolean isFraudulentCustomer = customerVerificationService.isFraudulentCustomer(userName);
        log.info("fraud check request for customer ", userName);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
