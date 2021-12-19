package com.eteration.simplebanking.util;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

import static org.junit.jupiter.api.Assertions.*;

class HttpUtilTest {

    @Test
    void contentTypeJson() {
        HttpHeaders httpHeaders = HttpUtil.ContentTypeJson();
        assertEquals(httpHeaders.getContentType().toString(),"application/json");
    }
}