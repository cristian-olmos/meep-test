package com.meep.test.infrastructure.repository;

import com.meep.test.domain.LocationFilter;
import com.meep.test.domain.LocationRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DummyLocationRepository implements LocationRepository {

    @Override
    public List<LocationFilter> getLocations() {
        return Arrays.asList(new LocationFilter(
                38.711046, -9.160096, 38.739429, -9.137115, Arrays.asList(545, 467, 473), "lisboa"
        ));
    }
}
