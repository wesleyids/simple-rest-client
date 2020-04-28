package com.simplerestclient;

public class URIBuilder {

    private String url;
    private String protocol;
    private String host;
    private String path;
    private StringBuilder parameters = new StringBuilder();
    private RestClientBuilder restClientBuilder;

    public URIBuilder(RestClientBuilder restClientBuilder) {
        this.restClientBuilder = restClientBuilder;
    }

    public URIBuilder url(String url) {
        if (url == null) throw new NullPointerException("url == null");
        this.url = url;
        return this;
    }

    public URIBuilder protocol(String protocol) {
        if (protocol == null) throw new NullPointerException("protocol == null");
        this.protocol = protocol;
        return this;
    }

    public URIBuilder host(String host) {
        if (host == null) throw new NullPointerException("host == null");
        this.host = host;
        return this;
    }

    public URIBuilder path(String path) {
        if (path == null) throw new NullPointerException("path == null");
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

    public String getFullURL() {
        if (url != null) {
            if (parameters.length() > 0) {
                return url + "?" + parameters;
            }
            return url;
        }

        url = mountURL();

        if (url == null) throw new NullPointerException("url == null");

        return url;
    }

    private String mountURL() {
        return null;
    }
}
