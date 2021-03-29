package com.ttu.estia.pojo;

public class StudentSignupDto {

    private String username;

    private String password;

    public StudentSignupDto() {

    }

    public StudentSignupDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}