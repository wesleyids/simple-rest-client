package com.simplerestclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Execute {

    private URL url;
    private HttpURLConnection http;
    private String METHOD = "";
    private String BASE_URL = "";

    Execute( String url, String method) {
        if (url == null) {
            throw new NullPointerException();
        }
        BASE_URL = url;
        METHOD = method;
    }

    Result exec() throws IOException {
        url = new URL(BASE_URL);
        http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod(METHOD);
        return new Result(this.http);
    }
}
