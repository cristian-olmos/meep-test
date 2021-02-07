package com.meep.test.application;

import com.meep.test.domain.Filter;
import com.meep.test.domain.Vehicle;
import com.meep.test.domain.VehiclesClient;
import com.meep.test.domain.VehiclesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
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

    public void updateVehicles() {
        List<Vehicle> apiVehicles = meepClient.getVehicles(38.711046, -9.160096, 38.739429, -9.137115, Arrays.asList(545, 467, 473));
        Set<Vehicle> dbVehicles = vehiclesRepository.getVehicles(new Filter(38.711046, -9.160096, 38.739429, -9.137115, Arrays.asList(545, 467, 473)));

        Set<Vehicle> intersection = apiVehicles.stream()
                .distinct()
                .filter(dbVehicles::contains)
                .collect(Collectors.toSet());
        log.info("intersection {}", intersection.size());
        apiVehicles.removeAll(intersection);
        log.info("Vehicle to add: {}", apiVehicles.size());
        vehiclesRepository.save(apiVehicles);
        dbVehicles.removeAll(intersection);
        log.info("Vehicle to remove: {}", dbVehicles.size());
        vehiclesRepository.remove(dbVehicles);
    }

}
