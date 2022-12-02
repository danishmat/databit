package com.org.fraud.util;

import com.org.fraud.model.URLParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.net.URI;

@Component
public class UserManagementURIBuilder extends URIBuilderUtil {

    public static URI getUserManagementURI() {
        URLParameters urlParameters = new URLParameters();
        urlParameters.setScheme(Constants.HTTPS_SCHEME);
        urlParameters.setHost(Constants.HOST);
        urlParameters.setPort(Constants.PORT);
        urlParameters.setPath(Constants.RESOURCE_PATH);
        return buildURI(urlParameters);
    }
}
