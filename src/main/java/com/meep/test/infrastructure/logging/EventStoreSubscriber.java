package com.meep.test.infrastructure.logging;

import com.meep.test.shared.domain.DomainEvent;
import com.meep.test.shared.domain.EventRepository;
import com.meep.test.shared.domain.Subscriber;
import org.springframework.stereotype.Component;

@Component
public class EventStoreSubscriber implements Subscriber {

    private EventRepository repository;

    public EventStoreSubscriber(EventRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isSuscribedTo(DomainEvent domainEvent) {
        return true;
    }

    @Override
    public void handle(DomainEvent domainEvent) {
        repository.save(domainEvent);
    }
}
