package com.ttu.estia.pojo;

public class BlacklistedSiteDto {

    private Integer studentId;

    private String website;

    public BlacklistedSiteDto() {

    }

    public BlacklistedSiteDto(Integer studentId, String website) {
        this.studentId = studentId;
        this.website = website;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

