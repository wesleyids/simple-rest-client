package com.simplerestclient;

import java.util.Map;

public class URLBuilder {

    StringBuilder url = new StringBuilder();

    public URLBuilder() {
        url.append("?");
    }

    public void addQueryParam(String key, String value) {
        if (Utils.isNull(key)) {
            throw new NullPointerException("key is null");
        }
        if (Utils.isNull(value)) {
            throw new NullPointerException("value is null");
        }

        url.append(key);
        url.append("=");
        url.append(value);
        url.append("&");
    }

    public String getURL() {
        String result = url.toString();

        if (result.endsWith("&")) {
            result = result.substring(0, result.length()-1);
        }

        return result;
    }

}
