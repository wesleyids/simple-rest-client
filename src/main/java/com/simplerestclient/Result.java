package com.simplerestclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class Result {

    private HttpURLConnection http;

    Result(HttpURLConnection http) {
        this.http = http;
    }

    String call() throws IOException {
        String body = getBodyResponse();
        return body;
    }

    private String getBodyResponse() throws IOException {
        StringBuilder response = null;
        if (this.http.getResponseCode() == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.http.getInputStream()));
            response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();
        }
        return response == null ? "" : response.toString();
    }
}
