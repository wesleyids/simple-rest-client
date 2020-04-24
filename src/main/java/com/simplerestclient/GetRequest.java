package com.simplerestclient;

import java.io.IOException;

public class GetRequest {

    private String METHOD;
    private String BASE_URL;

    public GetRequest(String url, String method) {
        if (url == null) {
            throw new NullPointerException();
        }
        BASE_URL = url;
        METHOD = method;
    }

    public Result exec() throws IOException {
        Execute execute = new Execute(BASE_URL, METHOD);
        return execute.exec();
    }
}
