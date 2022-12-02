package com.org.clients.notification.model;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message,
        String firstName
) {
}
