package com.org.notification.service;

import com.org.clients.notification.model.NotificationRequest;
import com.org.notification.model.Notification;
import com.org.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface NotificationService {
    public void send(NotificationRequest notificationRequest);
}
