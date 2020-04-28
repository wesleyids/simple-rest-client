package com.simplerestclient;

public class RestClient {

    public RestClientBuilder create() {
        return new RestClientBuilder();
    }

    public RestClientBuilder create(String url) {
        return new RestClientBuilder().url(url);
    }
}
