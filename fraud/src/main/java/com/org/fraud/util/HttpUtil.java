package com.org.fraud.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import java.util.Base64;

public class HttpUtil {

    public static HttpHeaders getHttpHeader() {
        String authStr = Constants.USER_NAME+":"+Constants.PASS_WORD;
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add(Constants.AUTHORIZATION, Constants.AUTH_METHOD + base64Creds);
        return headers;
    }

    public static HttpEntity getHTTPRequest() {
        HttpHeaders httpHeader = getHttpHeader();
        HttpEntity httpRequest = new HttpEntity(httpHeader);
        return httpRequest;
    }
}
