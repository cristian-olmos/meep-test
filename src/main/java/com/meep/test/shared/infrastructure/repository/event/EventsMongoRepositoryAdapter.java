package com.meep.test.shared.infrastructure.repository.event;

import com.meep.test.shared.domain.DomainEvent;
import com.meep.test.shared.domain.EventRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EventsMongoRepositoryAdapter implements EventRepository {

    private EventsMongoRepository eventsMongoRepository;

    public EventsMongoRepositoryAdapter(EventsMongoRepository eventsMongoRepository) {
        this.eventsMongoRepository = eventsMongoRepository;
    }

    @Override
    public void save(DomainEvent domainEvent) {
        eventsMongoRepository.save(domainEvent);
    }
}
