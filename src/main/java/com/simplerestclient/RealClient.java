package com.simplerestclient;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class RealClient {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        example05();

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("\nExecution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    static void example01() throws IOException {
        String rest = new RestClient().create()
                .url("https://viacep.com.br/ws/01001000/json/")
                .get()
                .call();
    }

    static void example02() throws IOException {
        new RestClient().create()
                .url()
                .scheme("http")
                .domain("localhost")
                .port("3000")
                .path("/api/user/5ea82f5ca7a520823b94364b")
                .builder()
                .get()
                .call();
    }

    static void example03() throws IOException {
        new RestClient().create()
                .url(new URIBuilder()
                        .scheme("http")
                        .domain("localhost")
                        .port("3000")
                        .path("/user/5ea82f5ca7a520823b94364b")
                        .addParam("email", "homer@simpson.com")
                )
                .get()
                .call();
    }

    static void example04() throws IOException {
        new RestClient().create()
                .url("http://localhost:3000/api/user/5ea82f5ca7a520823b94364b")
                .addParam("name", "homer")
                .addParam("email", "homer@simpson.com")
                .get()
                .call();
    }

    static void example05() throws IOException {
        new RestClient()
                .create("http://localhost:3000/api/user/5ea82f5ca7a520823b94364b")
                .get()
                .call();
    }

}
