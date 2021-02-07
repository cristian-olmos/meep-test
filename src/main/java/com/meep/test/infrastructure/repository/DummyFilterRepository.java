package com.meep.test.infrastructure.repository;

import com.meep.test.domain.Filter;
import com.meep.test.domain.FilterRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DummyFilterRepository implements FilterRepository {

    @Override
    public List<Filter> getAll() {
        return Arrays.asList(
                new Filter("lisboa", 38.711046, -9.160096, 38.739429, -9.137115, Arrays.asList(545, 467, 473)),
                new Filter("asd", 38.711046, -9.160096, 38.739429, -9.137115, Arrays.asList(545, 467, 473))
        );
    }
}
