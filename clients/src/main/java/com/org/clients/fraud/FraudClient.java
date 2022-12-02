package com.org.clients.fraud;

import com.org.clients.fraud.model.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("fraud")
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check/{userName}")
    FraudCheckResponse isFraudster(
            @PathVariable("userName") String userName) ;
}
