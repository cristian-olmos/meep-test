package com.meep.test.domain.vehicle;

import com.meep.test.domain.Filter;

import java.util.Set;

public interface VehiclesVendorRepository {

    Set<Vehicle> getVehicles(Filter filter);

}