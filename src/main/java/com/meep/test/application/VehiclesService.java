package com.meep.test.application;

import com.meep.test.domain.Filter;
import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehicleWasAdded;
import com.meep.test.domain.vehicle.VehicleWasRemoved;
import com.meep.test.domain.vehicle.VehiclesRepository;
import com.meep.test.domain.vehicle.VehiclesVendorRepository;
import com.meep.test.shared.domain.DomainEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VehiclesService {

    private static final Logger log = LoggerFactory.getLogger(VehiclesService.class);

    private VehiclesVendorRepository vehiclesVendorRepository;

    private VehiclesRepository vehiclesRepository;

    private DomainEventPublisher domainEventPublisher;

    public VehiclesService(VehiclesVendorRepository vehiclesVendorRepository, VehiclesRepository vehiclesRepository, DomainEventPublisher domainEventPublisher) {
        this.vehiclesVendorRepository = vehiclesVendorRepository;
        this.vehiclesRepository = vehiclesRepository;
        this.domainEventPublisher = domainEventPublisher;
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
        saveNewVehicles(apiVehicles);
        dbVehicles.removeAll(intersection);
        removeOldVehicles(dbVehicles);
    }

    private void removeOldVehicles(Set<Vehicle> dbVehicles) {
        if (!CollectionUtils.isEmpty(dbVehicles)) {
            vehiclesRepository.remove(dbVehicles);
            for (Vehicle dbVehicle : dbVehicles) {
                domainEventPublisher.publish(new VehicleWasRemoved(dbVehicle.getId(), dbVehicle.getName()));
            }
        }
    }

    private void saveNewVehicles(Set<Vehicle> apiVehicles) {
        if (!CollectionUtils.isEmpty(apiVehicles)) {
            vehiclesRepository.save(apiVehicles);
            for (Vehicle vehicle : apiVehicles) {
                domainEventPublisher.publish(new VehicleWasAdded(vehicle.getId(), vehicle.getName()));
            }
        }
    }

}
