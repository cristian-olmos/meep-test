package com.meep.test.domain;

import java.util.List;

public class LocationFilter {
    private Double lowerLat;
    private Double leftLon;
    private Double upperLat;
    private Double rightLon;
    private List<Integer> companyZoneIds;
    private String city;

    public LocationFilter(Double lowerLat, Double leftLon, Double upperLat, Double rightLon, List<Integer> companyZoneIds, String city) {
        this.lowerLat = lowerLat;
        this.leftLon = leftLon;
        this.upperLat = upperLat;
        this.rightLon = rightLon;
        this.companyZoneIds = companyZoneIds;
        this.city = city;
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

    public List<Integer> getCompanyZoneIds() {
        return companyZoneIds;
    }

    public String getCity() {
        return city;
    }
}
