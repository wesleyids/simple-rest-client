package com.simplerestclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

    private String urlbase;
    private String method;
    private String data;
    private URL url;
    private HttpURLConnection http;

    public Request(String url, String method) {
        this.urlbase = url;
        this.method = method;
    }

    public Request(String url, String method, String data) {
        this.urlbase = url;
        this.method = method;
        this.data = data;
    }

    public Result invoke() throws IOException {
        url = new URL(urlbase);
        http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod(method);
        return new Result(this.http);
    }
}
