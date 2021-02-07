package com.meep.test.infrastructure.repository;

import com.meep.test.domain.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface JpaWrapperRepository extends MongoRepository<Vehicle, String> {

    @Query(value = "{'x':{ $gte: ?1, $lte: ?3}}")
    List<Vehicle> findByFilter(Double lowerLat, Double leftLon, Double upperLat, Double rightLon);
}
