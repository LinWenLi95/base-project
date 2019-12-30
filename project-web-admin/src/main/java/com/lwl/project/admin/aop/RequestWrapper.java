package com.lwl.project.admin.aop;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.support.HttpRequestWrapper;

public class RequestWrapper extends HttpRequestWrapper {

    public RequestWrapper(HttpRequest request) {
        super(request);
    }

}
