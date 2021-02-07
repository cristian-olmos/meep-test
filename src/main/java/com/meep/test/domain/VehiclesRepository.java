package com.meep.test.domain;

import java.util.List;
import java.util.Set;

public interface VehiclesRepository {

    Set<Vehicle> getVehicles(Filter filter);

    void save(List<Vehicle> vehicles);

    void remove(Set<Vehicle> vehicles);
}
