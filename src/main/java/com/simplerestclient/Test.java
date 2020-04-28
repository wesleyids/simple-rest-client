package com.simplerestclient;

import java.net.HttpURLConnection;
import java.net.URL;

public class Test {

    public static void main(String[] args) throws Exception {
        testBuildHeader();
        testBuildUrl();
    }

    public static void testBuildUrl() throws Exception {
        URLBuilder urlBuilder = new URLBuilder();
        urlBuilder.addQueryParam("nome", "Wesley");
        urlBuilder.addQueryParam("sobrenome", "Inacio");
        urlBuilder.addQueryParam("idade", "27");

        String url = urlBuilder.getURL();
        String result = "?nome=Wesley&sobrenome=Inacio&idade=27";

        if (!result.equals(url)) {
            throw new Exception("URL not formatted correctly: " + url);
        }
    }

    public static void testBuildHeader() throws Exception {
        URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        HeaderBuilder headerBuilder = new HeaderBuilder();
        headerBuilder.add("Content-Type", "application/json");
        headerBuilder.add(Header.CONTENT_TYPE, "application/json");

//        HttpURLConnection headers = headerBuilder.getHeaders();

//        if (headers.getRequestProperties().size() == 0) {
//            throw new Exception("Header empty");
//        }
    }
}

