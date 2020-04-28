package com.simplerestclient;

import java.util.HashMap;
import java.util.Map;

public class HeaderBuilder {

    private Map<String, String> headers = new HashMap<String, String>();

    public void add(String key, String value) {
        if (Utils.isNull(key)) {
            throw new NullPointerException("key is null");
        }
        if (Utils.isNull(value)) {
            throw new NullPointerException("value is null");
        }
        this.headers.put(key, value);
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    boolean hasHeader() {
        if (headers.size() > 0) {
            return true;
        }
        return false;
    }
}
