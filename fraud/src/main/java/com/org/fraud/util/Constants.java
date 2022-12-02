package com.org.fraud.util;

import org.springframework.context.annotation.Configuration;


public class Constants {

    public static final String USER_JSON_PATH = "$.response.items[1].username";
    public static final Integer HTTP_OK_STATUS = 200;
    public static final String HTTPS_SCHEME = "https";
    public static final String USER_NAME = "oggadmin";
    public static final String PASS_WORD ="Danish12345#";
    public static final String AUTH_METHOD = "Basic ";
    public static final String AUTHORIZATION = "Authorization";
    public static final String HOST = "45dn3k7cqqja.deployment.goldengate.us-ashburn-1.oci.oraclecloud.com";
    public static final Integer PORT = 443;
    public static String RESOURCE_PATH = "/services/adminsrvr/v2/authorizations/security";
    public static final int FRAUD_DAO_TYPE = 1;
}
