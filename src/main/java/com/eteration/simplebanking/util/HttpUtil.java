package com.eteration.simplebanking.util;

import org.springframework.http.HttpHeaders;

public class HttpUtil {

    private static final String HEADER_NAME_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_VALUE_JSON = "application/json;"; // Compliant

    public static HttpHeaders ContentTypeJson(){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HEADER_NAME_CONTENT_TYPE, HEADER_VALUE_JSON);
        return headers;
    }
}
