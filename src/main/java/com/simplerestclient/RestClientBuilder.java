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

    private String METHOD = "";
    private String METHOD_GET = "GET";
    private String METHOD_POST = "POST";
    private String METHOD_PUT = "PUT";
    private String METHOD_DELETE = "DELETE";

    public void addQueryParam(String key, String value) {
        this.urlBuilder.addQueryParam(key, value);
    }

    public RestClientBuilder addHeader(String key, String value) {
        return this;
    }
    public Result post() throws IOException {
        return new Execute(baseUrl, METHOD_POST).exec();
    }

    public Result get() throws IOException {
        //return new Execute(baseUrl, METHOD_GET).exec();
        GetRequest getRequest = new GetRequest(baseUrl, METHOD_GET);
        return getRequest.exec();
    }

    public Result put() throws IOException {
        return new Execute(baseUrl, METHOD_PUT).exec();
    }

    public Result delete() throws IOException {
        return new Execute(baseUrl, METHOD_DELETE).exec();
    }

    public RestClientBuilder showTime(Boolean condition) {
        if (condition) {

        }
        return this;
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
}
