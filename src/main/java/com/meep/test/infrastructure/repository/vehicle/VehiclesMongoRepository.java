package com.meep.test.infrastructure.repository.vehicle;

import com.meep.test.domain.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VehiclesMongoRepository extends MongoRepository<Vehicle, String> {

    @Query(value = "{'zone': ?0, 'x':{$gte:?2, $lte:?4},'y':{$gte:?1, $lte:?3},'companyZoneId': { $in: ?5}}")
    List<Vehicle> findByFilter(String zone, Double lowerLat, Double leftLon, Double upperLat, Double rightLon, List<Integer> companies);
}
