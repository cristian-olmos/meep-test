package com.meep.test.infrastructure.repository.event;

import com.meep.test.domain.DomainEvent;
import com.meep.test.domain.EventRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventsMongoRepositoryAdapter implements EventRepository {

    private EventsMongoRepository jpaRepository;

    public EventsMongoRepositoryAdapter(EventsMongoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(DomainEvent domainEvent) {
        jpaRepository.save(domainEvent);
    }
}
