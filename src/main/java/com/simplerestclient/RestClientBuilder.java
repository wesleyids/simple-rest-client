package com.simplerestclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RestClientBuilder {

    private String baseUrl;
    private Map<String, String> parameters = new HashMap<String, String>();
    private URL url;
    private HttpURLConnection http;
    private URLBuilder urlBuilder = new URLBuilder();

    public void addQueryParam(String key, String value) {
        this.urlBuilder.addQueryParam(key, value);
    }

    public RestClientBuilder addHeader(String key, String value) {
        return this;
    }

    public Result post() throws IOException {
        return request(HttpMethod.POST.name());
    }

    public Result get() throws IOException {
        return request(HttpMethod.GET.name());
    }

    public Result put() throws IOException {
        return request(HttpMethod.PUT.name());
    }

    public Result delete() throws IOException {
        return request(HttpMethod.DELETE.name());
    }

    private String mountURL() {
        StringBuilder result = new StringBuilder();

        if (parameters.size() > 0) {
            result.append("?");
        }

//        parameters.forEach((k, v) -> {
//
//        });

        return result.toString();
    }

    public RestClientBuilder url(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public RestClientBuilder json() {
        return this;
    }

    public Result request(String method) throws IOException {
        return new Request(this.baseUrl, method).invoke();
    }
}
