package com.meep.test.application;

import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehiclesRepository;
import com.meep.test.domain.vehicle.VehiclesVendorRepository;
import com.meep.test.shared.domain.DomainEventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Sets;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class VehiclesServiceTest {

    private VehiclesVendorRepository vehiclesVendorRepository;

    private VehiclesRepository vehiclesRepository;

    private VehiclesService vehiclesService;

    private DomainEventPublisher domainEventPublisher;

    @BeforeEach
    public void init() {
        vehiclesVendorRepository = Mockito.mock(VehiclesVendorRepository.class);
        vehiclesRepository = Mockito.mock(VehiclesRepository.class);
        domainEventPublisher = Mockito.mock(DomainEventPublisher.class);
        vehiclesService = new VehiclesService(vehiclesVendorRepository, vehiclesRepository, domainEventPublisher);
    }

    @Test
    public void given_db_empty_when_vendor_returns_vehicles_then_all_off_them_are_added() {

        when(vehiclesRepository.getVehicles(any())).thenReturn(getEmptyResult());
        when(vehiclesVendorRepository.getVehicles(any())).thenReturn(getVehicles());

        vehiclesService.updateVehicles(any());

        verify(vehiclesRepository, times(1)).save(getVehicles());
        verify(vehiclesRepository, times(0)).remove(any());
        verify(domainEventPublisher, times(3)).publish(any());

    }

    @Test
    public void given_db_return_vehicles_when_vendor_returns_vehicles_then_do_nothing() {

        when(vehiclesRepository.getVehicles(any())).thenReturn(getVehicles());
        when(vehiclesVendorRepository.getVehicles(any())).thenReturn(getVehicles());

        vehiclesService.updateVehicles(any());

        verify(vehiclesRepository, times(0)).save(getVehicles());
        verify(vehiclesRepository, times(0)).remove(any());
        verify(domainEventPublisher, times(0)).publish(any());

    }

    @Test
    public void given_db_and_api_return_different_vehicles_then_vehicles_are_added_and_vehicles_are_removed() {
        Set<Vehicle> vehicles = getVehicles();
        Set<Vehicle> vehicles2 = getVehicles();
        vehicles.remove(new Vehicle("id1", "name1", -1d, -2d, 1, "zone1"));
        vehicles2.remove(new Vehicle("id2", "name2", -1d, -2d, 2, "zone3"));
        when(vehiclesRepository.getVehicles(any())).thenReturn(vehicles);
        when(vehiclesVendorRepository.getVehicles(any())).thenReturn(vehicles2);

        vehiclesService.updateVehicles(any());

        verify(vehiclesRepository, times(1)).save(any());
        verify(vehiclesRepository, times(1)).remove(any());
        verify(domainEventPublisher, times(2)).publish(any());

    }

    private Set<Vehicle> getVehicles() {
        return Sets.newSet(
                new Vehicle("id1", "name1", -1d, -2d, 1, "zone1"),
                new Vehicle("id2", "name2", -1d, -2d, 2, "zone3"),
                new Vehicle("id3", "name3", -1d, -2d, 3, "zone3")
        );
    }

    private Set<Vehicle> getEmptyResult() {
        return new HashSet<>();
    }

}