package com.meep.test.domain.vehicle;

import com.meep.test.domain.LocationFilter;

import java.util.List;
import java.util.Set;

public interface VehiclesRepository {

    Set<Vehicle> getVehicles(LocationFilter locationFilter);

    void save(List<Vehicle> vehicles);

    void remove(Set<Vehicle> vehicles);

    Set<String> getVehiclesIds();
}
