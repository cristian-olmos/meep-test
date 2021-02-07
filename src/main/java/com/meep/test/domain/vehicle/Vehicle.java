package com.meep.test.domain.vehicle;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "vehicles")
public class Vehicle {
    @Id private String id;
    private String name;
    private Double x;
    private Double y;
    private Integer companyZoneId;
    private String zone;

    public Vehicle(String id, String name, Double x, Double y, Integer companyZoneId, String zone) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.companyZoneId = companyZoneId;
        this.zone = zone;
    }

    public String getZone() {
        return zone;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Integer getCompanyZoneId() {
        return companyZoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(name, vehicle.name) && Objects.equals(companyZoneId, vehicle.companyZoneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, companyZoneId);
    }
}
