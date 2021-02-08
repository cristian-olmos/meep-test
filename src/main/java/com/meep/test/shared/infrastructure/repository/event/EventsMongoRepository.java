package com.meep.test.shared.infrastructure.repository.event;

import com.meep.test.shared.domain.DomainEvent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventsMongoRepository extends MongoRepository<DomainEvent, String> {

}
