package com.meep.test.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    private String id;
    private String name;
    private String x;
    private String y;
    private String licencePlate;
    private String range;
    private String batteryLevel;
    private String helmets;
    private String model;
    private String resourceImageId;
    private String vehicleGenEcooltra;
    private String realTimeData;
    private String resourceType;
    private String companyZoneId;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getRange() {
        return range;
    }

    public String getBatteryLevel() {
        return batteryLevel;
    }

    public String getHelmets() {
        return helmets;
    }

    public String getModel() {
        return model;
    }

    public String getResourceImageId() {
        return resourceImageId;
    }

    public String getVehicleGenEcooltra() {
        return vehicleGenEcooltra;
    }

    public String getRealTimeData() {
        return realTimeData;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getCompanyZoneId() {
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
