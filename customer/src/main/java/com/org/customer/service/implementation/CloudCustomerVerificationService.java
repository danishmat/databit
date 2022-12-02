package com.org.customer.service.implementation;

import com.org.customer.dao.BaseDao;
import com.org.customer.dao.factory.AbstractDAOFactory;
import com.org.customer.service.CustomerVerificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
@Slf4j
public class CloudCustomerVerificationService implements CustomerVerificationService {
    @Override
    public boolean isFraudulentCustomer(String userName) {
        BaseDao customerDao = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.CUSTOMER).getDao();
        Optional<Boolean> isFraudulentCustomer = customerDao.send(userName);
        return isFraudulentCustomer.get();
    }
}
