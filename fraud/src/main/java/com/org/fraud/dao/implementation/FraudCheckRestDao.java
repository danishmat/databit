package com.org.fraud.dao.implementation;

import com.org.fraud.dao.FraudCheckDao;
import com.org.fraud.exception.CustomerVerificationException;
import com.org.fraud.model.URLParameters;
import com.org.fraud.util.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.Optional;
import org.springframework.http.HttpEntity;

@Component
@AllArgsConstructor
@Slf4j
public class FraudCheckRestDao implements FraudCheckDao {

private final URLParameters urlParameters;
    @Override
    public boolean isFraudulentCustomer(String userName) {
        ResponseEntity<String> response = getMigrationUser(userName);
        handleResponseError(response);
        boolean isFraud = verifyUser(response, userName);
        return isFraud;
    }

    private ResponseEntity<String>  getMigrationUser(String userName) {
        ResponseEntity<String> response = null;
        HttpEntity httpRequest = HttpUtil.getHTTPRequest();
        URI userManagementUrl = UserManagementURIBuilder.getUserManagementURI();
        response = new RestTemplate().exchange(
                userManagementUrl, HttpMethod.GET, httpRequest, String.class);
        return response;
    }

    private void handleResponseError(ResponseEntity<String> response) {
        if (response.getStatusCodeValue() != Constants.HTTP_OK_STATUS) {
            log.error(ErrorMessages.CUSTOMER_VERIFICATION_FAILED + response.getStatusCodeValue());
            throw new CustomerVerificationException(ErrorMessages.CUSTOMER_VERIFICATION_FAILED, response.getStatusCodeValue());
        }
    }

    private boolean verifyUser(ResponseEntity<String> response, String userName) {
        String user = parseUserResponse(response);
        if(user.equalsIgnoreCase(userName))
            return false;
        return true;
    }

    private String parseUserResponse(ResponseEntity<String> response) {
       return JsonParserUtil.parseJson(response.getBody(), Constants.USER_JSON_PATH);
    }

    @Override
    public Optional send(Object customer) {
       Boolean isValidCustomer = isFraudulentCustomer((String) customer);
        return Optional.of(isValidCustomer);
    }
}
