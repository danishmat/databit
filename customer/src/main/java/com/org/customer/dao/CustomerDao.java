package com.org.customer.dao;

import com.org.customer.model.Customer;

import java.util.Optional;

public interface CustomerDao extends BaseDao{
 /**
  *  Customer verification
  * @param userName
  * @return
  */
 public boolean isFraudulentCustomer(String userName);

 //Additional methods specific to customer.
}