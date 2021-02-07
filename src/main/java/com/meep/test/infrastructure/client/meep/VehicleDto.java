package com.meep.test.infrastructure.client.meep;

import java.util.Objects;

public class VehicleDto {

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
        VehicleDto vehicle = (VehicleDto) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(name, vehicle.name) && Objects.equals(companyZoneId, vehicle.companyZoneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, companyZoneId);
    }

}
