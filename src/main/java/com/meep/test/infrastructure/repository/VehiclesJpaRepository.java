package com.meep.test.infrastructure.repository;

import com.meep.test.domain.Vehicle;
import com.meep.test.domain.VehiclesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VehiclesJpaRepository implements VehiclesRepository {

    private JpaWrapperRepository jpaRepository;

    public VehiclesJpaRepository(JpaWrapperRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Vehicle> getVehicles() {
        return jpaRepository.findAll();
    }

    @Override
    public void save(List<Vehicle> vehicles) {
        jpaRepository.saveAll(vehicles);
    }

    @Override
    public void remove(List<Vehicle> vehicles) {
        jpaRepository.deleteAll(vehicles);
    }
}
