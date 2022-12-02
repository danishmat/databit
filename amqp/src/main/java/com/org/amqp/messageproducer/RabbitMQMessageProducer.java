package com.org.amqp.messageproducer;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class RabbitMQMessageProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payLoad, String exchange, String routingKey) {
        log.info("Publishing the message "+exchange+"routing key"+routingKey+"PayLoad"+payLoad);
        amqpTemplate.convertAndSend(exchange, routingKey, payLoad);
        log.info("Publishing the message "+exchange+"routing key"+routingKey+"PayLoad"+payLoad);
    }
}
