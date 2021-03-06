package com.meep.test.domain.vehicle;

import com.meep.test.shared.domain.DomainEvent;

public class VehicleWasRemoved extends DomainEvent {
    private final String vehicleId;
    private final String name;

    public VehicleWasRemoved(String id, String name) {
        this.vehicleId = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "VehicleWasRemoved{" +
                "vehicleId='" + vehicleId + '\'' +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
