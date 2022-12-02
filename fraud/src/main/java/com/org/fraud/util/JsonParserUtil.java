package com.org.fraud.util;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class responsible for parsing json .
 */
public class JsonParserUtil {

    /**
     *  Parsing Json from corresponding json path.
     * @param jsonResponse
     * @param jsonPath
     * @return
     */
    public static String parseJson( String jsonResponse, String jsonPath) {
        String response = "";
        Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonResponse);
        response = JsonPath.read(document, jsonPath);
        return response;
    }
}
