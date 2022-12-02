package com.org.customer.dao.factory;

import com.org.customer.dao.BaseDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public abstract class AbstractDAOFactory {
    // List of AbstractDAOFactory types supported by the abstract Factory
 public static final int CUSTOMER = 1;
 public static final int NOTIFICATION = 2;

 public abstract BaseDao getDao();

    public static AbstractDAOFactory getDAOFactory(Integer factoryType) {
        switch(factoryType) {
            case CUSTOMER :
                return CustomerDaoFactory.getInstance();
            case NOTIFICATION :
                return NotificationDaoFactory.getInstance();
            default :
                return null;
        }
    }
}
