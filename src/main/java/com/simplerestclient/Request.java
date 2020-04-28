package com.simplerestclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Request {

    private URIBuilder uriBuilder;
    private String method;
    private String data;
    private URL url;
    private HttpURLConnection http;
    private HeaderBuilder headerBuilder;

    public Request(URIBuilder uriBuilder, HeaderBuilder headerBuilder, String method) {
        this.uriBuilder = uriBuilder;
        this.headerBuilder = headerBuilder;
        this.method = method;
    }

    public Result invoke() throws IOException {
        url = new URL(uriBuilder.getURI());
        http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod(method);

        if (!HttpMethod.GET.name().equals(method) || !HttpMethod.OPTIONS.name().equals(method)) {
            http.setDoOutput(Boolean.TRUE);
        }

        if (headerBuilder.hasHeader()) {
            Map<String, String> headers = headerBuilder.getHeaders();
            headers.forEach((key, value) -> {
                http.setRequestProperty(key, value);
            });
        }

        return new Result(http);
    }
}
