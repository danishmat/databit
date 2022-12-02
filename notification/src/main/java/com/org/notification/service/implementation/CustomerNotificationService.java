package com.org.notification.service.implementation;

import com.org.clients.notification.model.NotificationRequest;
import com.org.notification.model.Notification;
import com.org.notification.repository.NotificationRepository;
import com.org.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerNotificationService implements NotificationService {

    private final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(Notification.builder()
                .toCustomerId(notificationRequest.toCustomerId())
                .toCustomerEmail(notificationRequest.toCustomerName())
                .sender("danish")
                .message(notificationRequest.message())
                .sendAt(LocalDateTime.now())
                .build());
    }
}
