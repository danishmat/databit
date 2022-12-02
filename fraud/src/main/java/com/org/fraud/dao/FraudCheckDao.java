package com.org.fraud.dao;

import org.springframework.stereotype.Component;

@Component
public interface FraudCheckDao extends BaseDao{
    boolean isFraudulentCustomer(String userName);
}
