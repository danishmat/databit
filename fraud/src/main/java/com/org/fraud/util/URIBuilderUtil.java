package com.org.fraud.util;

import com.org.fraud.model.URLParameters;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;

public abstract class URIBuilderUtil {

    public static URI  buildURI(URLParameters urlParameters){
      URI baseUri = null;
      URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme(urlParameters.getScheme())
                .setHost(urlParameters.getHost())
                .setPort(urlParameters.getPort())
                .setPath(urlParameters.getPath().toString());
      try {
          baseUri = uriBuilder.build();
      }
      catch(URISyntaxException uriSyntaxException) {

      }
        return baseUri;
    }
}
