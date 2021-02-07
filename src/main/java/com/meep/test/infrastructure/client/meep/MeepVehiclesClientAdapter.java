package com.meep.test.infrastructure.client.meep;

import com.meep.test.domain.LocationFilter;
import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehiclesClient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MeepVehiclesClientAdapter implements VehiclesClient {

    public MeepVehiclesClient meepVehiclesClient;

    public MeepVehiclesClientAdapter(MeepVehiclesClient meepVehiclesClient){
        this.meepVehiclesClient = meepVehiclesClient;
    }

    @Override
    public Set<Vehicle> getVehicles(LocationFilter filter) {
        List<VehicleDto> vehicles = meepVehiclesClient.getVehicles(
                filter.getCity(),
                filter.getLowerLat(),
                filter.getLeftLon(),
                filter.getUpperLat(),
                filter.getRightLon(),
                filter.getCompanyZoneIds()
        );

        return vehicles.stream().map(this::getVehicle).collect(Collectors.toSet());
    }

    private Vehicle getVehicle(VehicleDto v) {
        return Vehicle.fromVehicleDto(v);
    }
}
