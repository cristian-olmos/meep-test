package com.meep.test.domain.vehicle;

import com.meep.test.domain.LocationFilter;

import java.util.Set;

public interface VehiclesClient {

    Set<Vehicle> getVehicles(LocationFilter filter);

}