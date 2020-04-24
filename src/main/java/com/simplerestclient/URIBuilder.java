package com.simplerestclient;

public class URIBuilder {

    private String protocol;
    private String host;
    private String path;
    private String parameters;

    public URIBuilder protocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    @Override
    public String toString() {
        // return build uri in string
        return "URIBuilder{" +
                "protocol='" + protocol + '\'' +
                ", host='" + host + '\'' +
                ", path='" + path + '\'' +
                ", parameters='" + parameters + '\'' +
                '}';
    }
}
