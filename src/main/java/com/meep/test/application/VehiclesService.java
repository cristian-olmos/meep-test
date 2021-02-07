package com.meep.test.application;

import com.meep.test.domain.LocationFilter;
import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehiclesClient;
import com.meep.test.domain.vehicle.VehiclesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehiclesService {

    private static final Logger log = LoggerFactory.getLogger(VehiclesService.class);

    private VehiclesClient meepClient;

    private VehiclesRepository vehiclesRepository;

    public VehiclesService(VehiclesClient meepClient, VehiclesRepository vehiclesRepository) {
        this.meepClient = meepClient;
        this.vehiclesRepository = vehiclesRepository;
    }

    public void updateVehicles(LocationFilter locationFilter) {
        Set<Vehicle> apiVehicles = meepClient.getVehicles(locationFilter);
        long l = System.currentTimeMillis();
        Set<Vehicle> dbVehicles = vehiclesRepository.getVehicles(locationFilter);

        Set<Vehicle> intersection = apiVehicles.stream()
                .distinct()
                .filter(dbVehicles::contains)
                .collect(Collectors.toSet());
        log.info("intersection {}", intersection.size());
        apiVehicles.removeAll(intersection);
        log.info("Vehicle to add: {}", apiVehicles.size());
        vehiclesRepository.save(new ArrayList<>(apiVehicles));
        dbVehicles.removeAll(intersection);
        log.info("Vehicle to remove: {}", dbVehicles.size());
        vehiclesRepository.remove(dbVehicles);
        long l1 = System.currentTimeMillis();
        log.info("Time: " + (l1 - l)/1000f + " seconds");
    }

}
