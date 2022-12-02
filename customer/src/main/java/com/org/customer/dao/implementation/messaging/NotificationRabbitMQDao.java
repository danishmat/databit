package com.org.customer.dao.implementation.messaging;

import com.org.amqp.messageproducer.RabbitMQMessageProducer;
import com.org.clients.notification.model.NotificationRequest;
import com.org.customer.dao.NotificationDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class NotificationRabbitMQDao implements NotificationDao {
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Override
    public void publish(NotificationRequest notificationRequest) {
        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );
    }

    @Override
    public Optional send(Object notificationRequest) {
        publish((NotificationRequest) notificationRequest);
        return Optional.empty();
    }
}
