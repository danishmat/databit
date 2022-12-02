package com.org.customer.dao.factory;

import com.org.customer.context.ApplicationContextProvider;
import com.org.customer.dao.NotificationDao;
import com.org.customer.dao.implementation.messaging.NotificationRabbitMQDao;
import com.org.customer.util.Constants;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NotificationDaoFactory extends AbstractDAOFactory {

    private final int RABBIT_MQ = 1;
    private static  NotificationDaoFactory instance = null;

    private NotificationDaoFactory() {
        super();
    }

    public static NotificationDaoFactory getInstance() {
        if(instance == null)
            instance = new NotificationDaoFactory();
        return instance;
    }

    @Override
    public NotificationDao getDao() {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        switch(Constants.NOTIFICATION_DAO_TYPE) {
            case RABBIT_MQ:
                return applicationContext.getBean(NotificationRabbitMQDao.class);
            default :
                return null;
        }
    }
}

