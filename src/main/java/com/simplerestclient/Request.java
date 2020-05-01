package com.simplerestclient;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Request {

    private URIBuilder uriBuilder;
    private String method;
    private String data;
    private URL url;
    private HttpURLConnection http;
    private HeaderBuilder headerBuilder;
    private BodyBuilder bodyBuilder;

    public Request(URIBuilder uriBuilder, HeaderBuilder headerBuilder, BodyBuilder bodyBuilder, String method) {
        this.uriBuilder = uriBuilder;
        this.headerBuilder = headerBuilder;
        this.bodyBuilder = bodyBuilder;
        this.method = method;
    }

    public Result invoke() throws IOException {

        url = new URL(uriBuilder.getURI());
        http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod(method);

        if (headerBuilder.hasHeader()) {
            Map<String, String> headers = headerBuilder.getHeaders();
            headers.forEach((key, value) -> {
                http.setRequestProperty(key, value);
            });
        }

        if (HttpMethod.POST.valueOf(method).equals(HttpMethod.POST)) {
            http.setDoOutput(Boolean.TRUE);

            if (bodyBuilder.hasBody() && bodyBuilder.isJson()) {
                try (OutputStream os = http.getOutputStream()) {
                    byte[] bodyJson = bodyBuilder.getBody();
                    os.write(bodyJson, 0, bodyJson.length);
                    http.getOutputStream().write(bodyJson);

                    // FIXME: IllegalStateException: Already connected
//                    http.setRequestProperty(HttpHeader.CONTENT_LENGTH, String.valueOf(bodyJson.length));
                }
            }

        }

        return new Result(http);
    }
}
