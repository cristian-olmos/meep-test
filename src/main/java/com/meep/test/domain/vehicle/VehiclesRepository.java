package com.meep.test.domain.vehicle;

import com.meep.test.domain.Filter;

import java.util.Set;

public interface VehiclesRepository {

    Set<Vehicle> getVehicles(Filter filter);

    void save(Set<Vehicle> vehicles);

    void remove(Set<Vehicle> vehicles);
}
