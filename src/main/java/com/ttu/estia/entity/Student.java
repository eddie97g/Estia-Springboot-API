package com.ttu.estia.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "student")
    private List<BlacklistedSite> blacklistedSites;

    public Student() {

    }

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<BlacklistedSite> getBlacklistedSites() {
        return blacklistedSites;
    }

    public void setBlacklistedSites(List<BlacklistedSite> blacklistedSites) {
        this.blacklistedSites = blacklistedSites;
    }
}
