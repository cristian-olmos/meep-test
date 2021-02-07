package com.meep.test.infrastructure.logging;

import com.meep.test.domain.DomainEvent;
import com.meep.test.domain.DomainEventPublisher;
import com.meep.test.domain.EventRepository;
import com.meep.test.domain.Subscriber;
import org.springframework.stereotype.Component;

@Component
public class LoggingEventsSubscriber implements Subscriber {

    private EventRepository repository;

    public LoggingEventsSubscriber(EventRepository repository) {
        this.repository = repository;
        DomainEventPublisher.getInstance().subscribe(this);
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
