package com.meep.test.infrastructure.repository;

import com.google.common.collect.Sets;
import com.meep.test.domain.Filter;
import com.meep.test.domain.Vehicle;
import com.meep.test.domain.VehiclesRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class VehiclesJpaRepository implements VehiclesRepository {

    private JpaWrapperRepository jpaRepository;

    public VehiclesJpaRepository(JpaWrapperRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Set<Vehicle> getVehicles(Filter filter) {
        return Sets.newConcurrentHashSet(jpaRepository.findByFilter(
                filter.getLowerLat(),
                filter.getLeftLon(),
                filter.getUpperLat(),
                filter.getRightLon()
        ));

    }

    @Override
    public void save(List<Vehicle> vehicles) {
        jpaRepository.saveAll(vehicles);
    }

    @Override
    public void remove(Set<Vehicle> vehicles) {
        jpaRepository.deleteAll(vehicles);
    }

}
