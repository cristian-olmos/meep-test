package com.meep.test.infrastructure.rest;

import com.meep.test.domain.Filter;
import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehiclesVendorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class VehiclesVendorfFeignRepository implements VehiclesVendorRepository {

    private VehiclesMeepClient vehiclesMeepClient;

    public VehiclesVendorfFeignRepository(VehiclesMeepClient vehiclesMeepClient){
        this.vehiclesMeepClient = vehiclesMeepClient;
    }

    @Override
    public Set<Vehicle> getVehicles(Filter filter) {
        List<VehicleDto> vehicles = vehiclesMeepClient.getVehicles(
                filter.getZone(),
                filter.getLowerLat(),
                filter.getLeftLon(),
                filter.getUpperLat(),
                filter.getRightLon(),
                filter.getCompanies()
        );

        return vehicles.stream().map(v -> new Vehicle(
                v.getId(),
                v.getName(),
                v.getX(),
                v.getY(),
                v.getCompanyZoneId(),
                filter.getZone()
        )).collect(Collectors.toSet());
    }
}
