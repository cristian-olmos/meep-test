package com.meep.test.domain;

import java.util.List;

public class Filter {
    private Double lowerLat;
    private Double leftLon;
    private Double upperLat;
    private Double rightLon;
    private List<Integer> companies;

    public Filter(Double lowerLat, Double leftLon, Double upperLat, Double rightLon, List<Integer> companies) {
        this.lowerLat = lowerLat;
        this.leftLon = leftLon;
        this.upperLat = upperLat;
        this.rightLon = rightLon;
        this.companies = companies;
    }

    public Double getLowerLat() {
        return lowerLat;
    }

    public Double getLeftLon() {
        return leftLon;
    }

    public Double getUpperLat() {
        return upperLat;
    }

    public Double getRightLon() {
        return rightLon;
    }

    public List<Integer> getCompanies() {
        return companies;
    }
}
