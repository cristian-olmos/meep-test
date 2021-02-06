package com.meep.test.domain;

import java.util.List;

public interface VehiclesRepository {

    List<Vehicle> getVehicles();

    void save(List<Vehicle> vehicles);

    void remove(List<Vehicle> vehicles);
}
