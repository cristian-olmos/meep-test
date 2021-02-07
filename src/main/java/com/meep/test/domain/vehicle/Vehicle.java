package com.meep.test.domain.vehicle;

import com.meep.test.domain.LocationFilter;
import com.meep.test.infrastructure.client.meep.VehicleDto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    private String id;
    private String name;
    private Double x;
    private Double y;
    private String licencePlate;
    private Integer range;
    private Integer batteryLevel;
    private Integer helmets;
    private String model;
    private String resourceImageId;
    private String vehicleGenEcooltra;
    private String realTimeData;
    private String resourceType;
    private Integer companyZoneId;

    private Vehicle(String id, String name, Double x, Double y, String licencePlate, Integer range, Integer batteryLevel, Integer helmets, String model, String resourceImageId, String vehicleGenEcooltra, String realTimeData, String resourceType, Integer companyZoneId) {
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
        this.licencePlate = licencePlate;
        this.range = range;
        this.batteryLevel = batteryLevel;
        this.helmets = helmets;
        this.model = model;
        this.resourceImageId = resourceImageId;
        this.vehicleGenEcooltra = vehicleGenEcooltra;
        this.realTimeData = realTimeData;
        this.resourceType = resourceType;
        this.companyZoneId = companyZoneId;
    }

    public static Vehicle fromVehicleDto(VehicleDto v) {
        return new Vehicle(
                v.getId(),
                v.getName(),
                v.getX(),
                v.getY(),
                v.getLicencePlate(),
                v.getRange(),
                v.getBatteryLevel(),
                v.getHelmets(),
                v.getModel(),
                v.getResourceImageId(),
                v.getVehicleGenEcooltra(),
                v.getRealTimeData(),
                v.getResourceType(),
                v.getCompanyZoneId()

        );
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setX(Double x) {
        this.x = x;
    }

    private void setY(Double y) {
        this.y = y;
    }

    private void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    private void setRange(Integer range) {
        this.range = range;
    }

    private void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    private void setHelmets(Integer helmets) {
        this.helmets = helmets;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setResourceImageId(String resourceImageId) {
        this.resourceImageId = resourceImageId;
    }

    private void setVehicleGenEcooltra(String vehicleGenEcooltra) {
        this.vehicleGenEcooltra = vehicleGenEcooltra;
    }

    private void setRealTimeData(String realTimeData) {
        this.realTimeData = realTimeData;
    }

    private void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    private void setCompanyZoneId(Integer companyZoneId) {
        this.companyZoneId = companyZoneId;
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

    public String getLicencePlate() {
        return licencePlate;
    }

    public Integer getRange() {
        return range;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public Integer getHelmets() {
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

    public LocationFilter getLocation() {
        return null;
    }
}

