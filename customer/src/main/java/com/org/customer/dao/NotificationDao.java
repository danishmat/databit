package com.org.customer.dao;

import com.org.clients.notification.model.NotificationRequest;

public interface NotificationDao extends BaseDao{

    public void publish(NotificationRequest notificationRequest);

    //Additional methods specific to notification.
}
