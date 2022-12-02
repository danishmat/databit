package com.org.fraud.service.implementation;


import com.org.fraud.dao.BaseDao;
import com.org.fraud.dao.factory.AbstractDAOFactory;
import com.org.fraud.model.FraudCheckHistory;
import com.org.fraud.dao.FraudCheckHistoryRepository;
import com.org.fraud.service.UserVerificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class MigrationUserVerificationService
        implements UserVerificationService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(String userName) {
        BaseDao fraudDao = AbstractDAOFactory.getDAOFactory(AbstractDAOFactory.FRAUD).getDao();
       Optional<Boolean> isFraud = fraudDao.send(userName);
       Boolean isFraudUser = isFraud.get();
       if(isFraudUser)
           saveFraudulentCustomer(userName);
        return isFraudUser;
    }

    @Override
    public void saveFraudulentCustomer(String userName) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .userName(userName)
                .isFraudster(true)
                .createdAt(LocalDateTime.now())
                .build());
    }
}
