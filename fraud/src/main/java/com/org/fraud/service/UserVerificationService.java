package com.org.fraud.service;

import org.springframework.stereotype.Component;

@Component
public interface UserVerificationService {
   /**
    *
    * @param userName
    * @return
    */
   public boolean isFraudulentCustomer(String userName);

   /**
    * Saving the Fraud customer
    * @param userName
    */
   public void saveFraudulentCustomer(String userName);
}
