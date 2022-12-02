package com.org.customer.service;

import com.org.clients.notification.model.NotificationRequest;
import com.org.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomerNotificationService {
    /**
     * Send customer registration notifications to notification service
     */
    public void sendNotifications(Customer customer);
    public NotificationRequest buildNotificationMessage(Customer customer);
}
