package com.meep.test.infrastructure.repository.event;

import com.meep.test.domain.DomainEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventsMongoRepository extends MongoRepository<DomainEvent, String> {

}
