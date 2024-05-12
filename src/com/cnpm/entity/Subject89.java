package com.cnpm.entity;

public class Subject89 {
    private Integer id;
    private String name;
    private Integer creditNumber;
    private Integer semester;

    public Subject89() {
    }

    public Subject89(Integer id, String name, Integer creditNumber, Integer semester) {
        this.id = id;
        this.name = name;
        this.creditNumber = creditNumber;
        this.semester = semester;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditNumber() {
        return creditNumber;
    }

    public void setCreditNumber(Integer creditNumber) {
        this.creditNumber = creditNumber;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
