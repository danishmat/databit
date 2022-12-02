package com.org.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication(
        scanBasePackages = {
                "com.org.customer",
                "com.org.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.org.clients"
)
public class CustomerApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerApplication.class, args);
    }
}
