package com.simplerestclient;

import java.io.UnsupportedEncodingException;

public class BodyBuilder {

    private String bodyJson;

    BodyBuilder() {}

    BodyBuilder json(String bodyJson) {
        this.bodyJson = bodyJson;
        return this;
    }

    boolean isJson() {
        if (bodyJson == null || bodyJson.length() == 0) {
            return false;
        }
        return true;
    }

    boolean hasBody() {
        if (bodyJson != null && bodyJson.length() > 0) {
            return true;
        }
        return false;
    }

    byte[] getBody() throws UnsupportedEncodingException {
        if (bodyJson == null || bodyJson.length() == 0) {
            return "".getBytes();
        }

        try {
            return bodyJson.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new UnsupportedEncodingException(e.getMessage());
        }
    }
}
