package com.meep.test.application;

import com.meep.test.domain.*;
import com.meep.test.domain.vehicle.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehiclesService {

    private static final Logger log = LoggerFactory.getLogger(VehiclesService.class);

    private VehiclesVendorRepository vehiclesVendorRepository;

    private VehiclesRepository vehiclesRepository;

    public VehiclesService(VehiclesVendorRepository vehiclesVendorRepository, VehiclesRepository vehiclesRepository) {
        this.vehiclesVendorRepository = vehiclesVendorRepository;
        this.vehiclesRepository = vehiclesRepository;
    }

    public void updateVehicles(Filter filter) {
        log.info("Checking vehicles changes for filter {}", filter);
        Set<Vehicle> apiVehicles = vehiclesVendorRepository.getVehicles(filter);
        Set<Vehicle> dbVehicles = vehiclesRepository.getVehicles(filter);

        Set<Vehicle> intersection = apiVehicles.stream()
                .distinct()
                .filter(dbVehicles::contains)
                .collect(Collectors.toSet());
        apiVehicles.removeAll(intersection);
        vehiclesRepository.save(apiVehicles);
        for (Vehicle vehicle : apiVehicles) {
            DomainEventPublisher.getInstance().publish(new VehicleWasAdded(vehicle.getId(), vehicle.getName()));
        }
        dbVehicles.removeAll(intersection);
        vehiclesRepository.remove(dbVehicles);
        for (Vehicle dbVehicle : dbVehicles) {
            DomainEventPublisher.getInstance().publish(new VehicleWasRemoved(dbVehicle.getId(), dbVehicle.getName()));
        }
    }

}
