package com.cnpm.entity;

public class SubjectStatistic89 extends Subject89{
    private Float averageScore;
    private Float passRate;

    public SubjectStatistic89() {
        super();
    }

    public SubjectStatistic89(Integer id, String name, Integer creditNumber, Float averageScore, Float passRate) {
        super(id, name, creditNumber, 0);
        this.averageScore = averageScore;
        this.passRate = passRate;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Float getPassRate() {
        return passRate;
    }

    public void setPassRate(Float passRate) {
        this.passRate = passRate;
    }
}
