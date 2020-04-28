package com.simplerestclient;

public class URIBuilder {

    private String url;
    private String scheme;
    private String port;
    private String domain;
    private String path;
    private StringBuilder parameters = new StringBuilder();
    private RestClientBuilder restClientBuilder;

    public URIBuilder() {}

    public URIBuilder(URIBuilder uriBuilder) {
        this.scheme = uriBuilder.scheme;
        this.domain = uriBuilder.domain;
        this.port = uriBuilder.port;
        this.path = uriBuilder.path;
        this.parameters = uriBuilder.parameters;
    }

    public URIBuilder(RestClientBuilder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public URIBuilder url(String url) {
        if (url == null) throw new NullPointerException("url == null");
        this.url = url;
        return this;
    }

    public URIBuilder scheme(String scheme) {
        if (scheme == null) throw new NullPointerException("scheme == null");
        this.scheme = scheme;
        return this;
    }

    public URIBuilder port(String port) {
        if (port == null) throw new NullPointerException("port == null");
        this.port = port;
        return this;
    }

    public URIBuilder domain(String domain) {
        if (domain == null) throw new NullPointerException("domain == null");
        this.domain = domain;
        return this;
    }

    public URIBuilder path(String path) {
        this.path = path;
        return this;
    }

    public RestClientBuilder builder() {
        return restClientBuilder;
    }

    public URIBuilder addParam(String key, String value) {
        if (Utils.isNull(key)) {
            throw new NullPointerException("key is null");
        }
        if (Utils.isNull(value)) {
            throw new NullPointerException("value is null");
        }

        parameters.append(key);
        parameters.append("=");
        parameters.append(value);
        parameters.append("&");

        return this;
    }

    public String getURI() {
        if (url != null) {
            return withParameters(url);
        }

        url = mountURL();

        if (url == null) throw new NullPointerException("url == null");

        return withParameters(url);
    }

    private String mountURL() {
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append("://");
        sb.append(domain);
        sb.append(":");
        sb.append(port);

        if (path != null || path != "") {
            sb.append(path);
        }

        return sb.toString();
    }

    private String withParameters(String url) {
        if (parameters.length() > 0) {
            String params = parameters.toString();

            // FIXME
            if (params.endsWith("&")) {
                params = params.substring(0, params.length()-1);
            }
            return String.format("%s?%s", url, params);
        }
        return url;
    }
}
