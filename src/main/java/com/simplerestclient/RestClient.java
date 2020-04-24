package com.simplerestclient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

public class RestClient {

    // https://stackoverflow.com/questions/5204051/how-to-calculate-the-running-time-of-my-program

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        String rest = new RestClientBuilder()
                .url("https://viacep.com.br/ws/01001000/json/")
                .get()
                .resultTo(String.class);

        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("\nExecution time is " + formatter.format((end - start) / 1000d) + " seconds");

    }
}
