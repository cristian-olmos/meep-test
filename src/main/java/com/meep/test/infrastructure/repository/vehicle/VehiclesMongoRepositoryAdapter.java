package com.meep.test.infrastructure.repository.vehicle;

import com.google.common.collect.Sets;
import com.meep.test.domain.Filter;
import com.meep.test.domain.vehicle.Vehicle;
import com.meep.test.domain.vehicle.VehiclesRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class VehiclesMongoRepositoryAdapter implements VehiclesRepository {

    private VehiclesMongoRepository jpaRepository;

    public VehiclesMongoRepositoryAdapter(VehiclesMongoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Set<Vehicle> getVehicles(Filter filter) {
        return Sets.newConcurrentHashSet(jpaRepository.findByFilter(
                filter.getZone(),
                filter.getLowerLat(),
                filter.getLeftLon(),
                filter.getUpperLat(),
                filter.getRightLon(),
                filter.getCompanies()
        ));

    }

    @Override
    public void save(Set<Vehicle> vehicles) {
        jpaRepository.saveAll(vehicles);
    }

    @Override
    public void remove(Set<Vehicle> vehicles) {
        jpaRepository.deleteAll(vehicles);
    }

}
