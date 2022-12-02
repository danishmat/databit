package com.org.notification.consumer;


import com.org.clients.notification.model.NotificationRequest;
import com.org.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class NotificationConsumer implements IConsumer{

    private final NotificationService notificationService;

    @Override
    @RabbitListener(queues="${rabbitmq.queues.notification}")
    public void consume(NotificationRequest notificationRequest) {
        log.info("Consumed from the queue");
        notificationService.send(notificationRequest);
    }
}
