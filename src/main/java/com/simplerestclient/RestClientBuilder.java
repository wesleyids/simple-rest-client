package com.simplerestclient;

import java.io.IOException;

public class RestClientBuilder {

    private URIBuilder uriBuilder;
    private HeaderBuilder headerBuilder;

    public RestClientBuilder addParam(String key, String value) {
        uriBuilder.addParam(key, value);
        return this;
    }

    public RestClientBuilder addHeader(String key, String value) {
        if (headerBuilder == null) {
            this.headerBuilder = new HeaderBuilder();
        }
        headerBuilder.add(key, value);
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
        return new Request(uriBuilder, headerBuilder, method).invoke();
    }
}
