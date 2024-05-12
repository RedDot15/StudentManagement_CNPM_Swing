package com.cnpm.entity;

import java.util.Date;

public class Teacher89 {
    private Integer id;
    private String password;
    private String name;
    private Date dob;
    private String homeTown;
    private String address;

    public Teacher89() {
        super();
    }

    public Teacher89(Integer id, String password, String name, Date dob, String homeTown, String address) {
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.homeTown = homeTown;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
