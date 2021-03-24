package com.ttu.estia.entity;

import javax.persistence.*;

@Entity
@Table(name="blacklisted_site")
public class BlacklistedSite {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="website")
    private String website;

    @ManyToOne
    @JoinColumn(name="studentID")
    private Student student;

    public BlacklistedSite() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
