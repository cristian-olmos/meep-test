package com.meep.test.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "city_location")
@Data
public class Location {
    @Id
    private String id;
    private String city;
    private Double lowerLat;
    private Double leftLon;
    private Double upperLat;
    private Double rightLon;

}
