package com.ttu.estia.pojo;

import com.ttu.estia.entity.Student;

public class AuthenticationResponse {

    private final String jwt;

    private final long expiration;

    private Student student;

    public AuthenticationResponse(String jwt, long expiration, Student student) {
        this.jwt = jwt;
        this.expiration = expiration;
        this.student = student;
    }


    public String getJwt() {
        return this.jwt;
    }

    public long getExpiration() {
        return expiration;
    }

    public Student getStudent() {
        return student;
    }
}
