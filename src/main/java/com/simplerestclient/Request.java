package com.simplerestclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

    private URIBuilder uriBuilder;
    private String method;
    private String data;
    private URL url;
    private HttpURLConnection http;

    public Request(URIBuilder uriBuilder, String method) {
        this.uriBuilder = uriBuilder;
        this.method = method;
    }

    public Result invoke() throws IOException {
        url = new URL(uriBuilder.getURI());
        http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod(method);
        return new Result(this.http);
    }
}
