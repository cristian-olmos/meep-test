package com.meep.test.infrastructure.repository;

import com.meep.test.domain.LocationFilter;
import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehiclesRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class VehiclesJpaRepository implements VehiclesRepository {

    private JpaWrapperRepository jpaRepository;

    public VehiclesJpaRepository(JpaWrapperRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Set<Vehicle> getVehicles(LocationFilter locationFilter) {
        return new HashSet<>(jpaRepository.findAll());
    }

    @Override
    public void save(List<Vehicle> vehicles) {
        jpaRepository.saveAll(vehicles);
    }

    @Override
    public void remove(Set<Vehicle> vehicles) {
        jpaRepository.deleteAll(vehicles);
    }

    @Override
    public Set<String> getVehiclesIds() {
        return null;
    }

}
