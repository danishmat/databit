package com.org.fraud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FraudConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
