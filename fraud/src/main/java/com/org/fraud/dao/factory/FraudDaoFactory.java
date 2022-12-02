package com.org.fraud.dao.factory;

import com.org.fraud.dao.BaseDao;
import com.org.fraud.dao.implementation.FraudCheckRestDao;
import com.org.fraud.context.ApplicationContextProvider;
import com.org.fraud.util.Constants;
import org.springframework.context.ApplicationContext;

public class FraudDaoFactory extends AbstractDAOFactory {
    public static final int REST = 1;
    private static  FraudDaoFactory instance = null;
    private FraudDaoFactory(){
        super();
    }
    public static FraudDaoFactory getInstance() {
        if(instance == null)
            instance = new FraudDaoFactory();
        return instance;
    }

    @Override
    public BaseDao getDao() {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        switch(Constants.FRAUD_DAO_TYPE) {
            case REST:
                return applicationContext.getBean(FraudCheckRestDao.class);
            default :
                return null;
        }
    }
}
