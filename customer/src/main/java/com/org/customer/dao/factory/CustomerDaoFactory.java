package com.org.customer.dao.factory;

import com.org.customer.context.ApplicationContextProvider;
import com.org.customer.dao.CustomerDao;
import com.org.customer.dao.implementation.rest.CustomerRestDao;
import com.org.customer.util.Constants;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomerDaoFactory extends AbstractDAOFactory {

private final int REST = 1;

private static  CustomerDaoFactory instance = null;
private CustomerDaoFactory(){
    super();
}

public static CustomerDaoFactory getInstance() {
    if(instance == null)
        instance = new CustomerDaoFactory();
    return instance;
}

    @Override
    public CustomerDao getDao() {
        ApplicationContext  applicationContext = ApplicationContextProvider.getApplicationContext();
        switch(Constants.CUSTOMER_DAO_TYPE) {
            case REST:
                return applicationContext.getBean(CustomerRestDao.class);
            default :
                return null;
        }

    }
}
