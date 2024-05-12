package com.cnpm.entity;

public class LearningOutcome89 {
    private Integer id;
    private Integer studentId;
    private Integer courseId;
    private Float subscore1;
    private Float subscore2;
    private Float subscore3;
    private Float testScore;
    private Float overallScore;
    private String status;

    public LearningOutcome89() {
    }

    public LearningOutcome89(Integer id, Integer studentId, Integer courseId, Float subscore1, Float subscore2, Float subscore3, Float testScore, Float overallScore, String status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.subscore1 = subscore1;
        this.subscore2 = subscore2;
        this.subscore3 = subscore3;
        this.testScore = testScore;
        this.overallScore = overallScore;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Float getSubscore1() {
        return subscore1;
    }

    public void setSubscore1(Float subscore1) {
        this.subscore1 = subscore1;
    }

    public Float getSubscore2() {
        return subscore2;
    }

    public void setSubscore2(Float subscore2) {
        this.subscore2 = subscore2;
    }

    public Float getSubscore3() {
        return subscore3;
    }

    public void setSubscore3(Float subscore3) {
        this.subscore3 = subscore3;
    }

    public Float getTestScore() {
        return testScore;
    }

    public void setTestScore(Float testScore) {
        this.testScore = testScore;
    }

    public Float getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Float overallScore) {
        this.overallScore = overallScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
