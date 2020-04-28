package com.simplerestclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClientBuilder {

    private String baseUrl;
    private Map<String, String> parameters = new HashMap<String, String>();
    private URIBuilder uriBuilder;

    public RestClientBuilder addParam(String key, String value) {
        uriBuilder.addParam(key, value);
        return this;
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

    public URIBuilder url() {
        uriBuilder = new URIBuilder(this);
        return uriBuilder;
    }

    public RestClientBuilder url(URIBuilder uriBuilder) {
        this.uriBuilder = new URIBuilder(uriBuilder);
        return this;
    }

    public RestClientBuilder url(String url) {
        this.uriBuilder = new URIBuilder().url(url);
        return this;
    }

    public RestClientBuilder json() {
        return this;
    }

    public Result request(String method) throws IOException {
        return new Request(uriBuilder, method).invoke();
    }
}
