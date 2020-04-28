package com.simplerestclient;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RestClient {

    // https://stackoverflow.com/questions/5204051/how-to-calculate-the-running-time-of-my-program

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        String rest = new RestClientBuilder()
//                .url("https://viacep.com.br/ws/01001000/json/")
                .url()
                .protocol("http")
                .builder()
                .get()
                .getResponse();

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("\nExecution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }
}
