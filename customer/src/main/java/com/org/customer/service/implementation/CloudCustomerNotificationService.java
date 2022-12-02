package com.org.customer.service.implementation;

import com.org.clients.notification.model.NotificationRequest;
import com.org.customer.dao.BaseDao;
import com.org.customer.dao.factory.AbstractDAOFactory;
import com.org.customer.model.Customer;
import com.org.customer.service.CustomerNotificationService;
import com.org.customer.util.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class CloudCustomerNotificationService implements CustomerNotificationService {

    @Override
    public void sendNotifications(Customer customer) {
        NotificationRequest notificationMessage = buildNotificationMessage(customer);
        BaseDao notificationDao = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.NOTIFICATION).getDao();
        notificationDao.send(notificationMessage);
    }

    @Override
    public NotificationRequest buildNotificationMessage(Customer customer) {
        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format(Constants.MESSAGE),
                customer.getFirstName());
        return notificationRequest;
    }
}
