package com.org.customer.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class TrustStoreTest {

    public static void main(String[] args) throws KeyStoreException, CertificateException, IOException, NoSuchAlgorithmException {
        //KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        char[] pwdArray = "password".toCharArray();
        //Storing the JKS key store system
        //try (FileOutputStream fos = new FileOutputStream("newKeyStoreFileName.jks")) {
       //     trustStore.store(fos, pwdArray);
       // }
        //Loading JKS file into Keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("/Users/admin/cert/trust.jks"), pwdArray);
        Enumeration<String> aliases = ks.aliases();

       // trustStore.setCertificateEntry();
        //X509Certificate certificate ;


    }
}
