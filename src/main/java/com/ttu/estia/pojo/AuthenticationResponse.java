package com.ttu.estia.pojo;

public class AuthenticationResponse {

    private final String jwt;

    private final long expiration;

    public AuthenticationResponse(String jwt, long expiration) {
        this.jwt = jwt;
        this.expiration = expiration;
    }


    public String getJwt() {
        return this.jwt;
    }

    public long getExpiration() {
        return expiration;
    }
}
