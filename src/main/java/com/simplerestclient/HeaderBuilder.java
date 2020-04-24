package com.simplerestclient;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {

    private final HttpURLConnection connection;
    private Map<String, String> headers = new HashMap<String, String>();

    public HeaderBuilder(HttpURLConnection connection) {
        this.connection = connection;
    }

    public void addParameter(String key, String value) {
        this.add(key, value);
    }

    public void addParameter(Header header, String value) {
        this.add(header.toString(), value);
    }

    private void add(String key, String value) {
        if (Utils.isNull(key)) {
            throw new NullPointerException("key is null");
        }
        if (Utils.isNull(value)) {
            throw new NullPointerException("value is null");
        }
        this.headers.put(key, value);
    }

    public HttpURLConnection getHeaders() {
//        headers.forEach((k, v) -> {
//            connection.setRequestProperty(k, v);
//        });
        return connection;
    }
}
