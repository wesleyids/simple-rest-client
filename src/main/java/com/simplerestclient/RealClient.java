package com.simplerestclient;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

class RealClient {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        String rest = new RestClient().create()
                .url("https://viacep.com.br/ws/01001000/json/")
                .get()
                .getResponse();

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("\nExecution time is " + formatter.format((end - start) / 1000d) + " seconds");
    }

    static void runWithURL() {

    }

}
