package com.org.fraud.dao.factory;

import com.org.fraud.dao.BaseDao;

public abstract class AbstractDAOFactory {
    // List of DAO types supported by the Factory
    private final int REST = 1;
    public static final Integer FRAUD = 1;

    public abstract BaseDao getDao();

    public static AbstractDAOFactory getDAOFactory(Integer factoryType) {
        if(FRAUD == factoryType)
            return FraudDaoFactory.getInstance();
        else
            return null;
    }
}
