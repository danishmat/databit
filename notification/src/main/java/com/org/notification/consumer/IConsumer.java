package com.org.notification.consumer;

import com.org.clients.notification.model.NotificationRequest;

public interface IConsumer {

    public void consume(NotificationRequest notificationRequest);
}
