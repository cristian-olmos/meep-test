package com.meep.test.infrastructure.repository;

import com.meep.test.domain.LocationFilter;
import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehiclesRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Primary
public class InMemoryVehiclesRepository implements VehiclesRepository {

    @Override
    public Set<Vehicle> getVehicles(LocationFilter locationFilter) {
        return null;
    }

    @Override
    public void save(List<Vehicle> vehicles) {

    }

    @Override
    public void remove(Set<Vehicle> vehicles) {

    }

    @Override
    public Set<String> getVehiclesIds() {
        return null;
    }

//    private Map<LocationFilter, Map<String, Vehicle>> vehicles;
//
//    public InMemoryVehiclesRepository() {
//        this.vehicles = new HashMap<>();
//    }
//
//    @Override
//    public Set<Vehicle> getVehicles(LocationFilter locationFilter) {
//        return new HashSet<>(vehicles.get(locationFilter).values());
//    }
//
//    @Override
//    public void save(List<Vehicle> vehicles) {
//        vehicles.forEach(
//                v -> {
//                    if (!this.vehicles.containsKey(v.getLocation())) {
//                        this.vehicles.put(v.getLocation(), new HashMap<>());
//                    }
//                    this.vehicles.get(v.getLocation()).put(v.getId(), v);
//                }
//        );
//    }
//
//    @Override
//    public void remove(Set<Vehicle> vehicles) {
//        vehicles.forEach(
//                v -> this.vehicles.remove(v.getId())
//        );
//    }
//
//    @Override
//    public Set<String> getVehiclesIds() {
//        return new HashSet<>(vehicles.keySet());
//    }

}
