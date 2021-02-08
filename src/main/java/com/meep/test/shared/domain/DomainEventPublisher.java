package com.meep.test.shared.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainEventPublisher {

    @Autowired
    private List<? extends Subscriber> list;

    public void publish(DomainEvent domainEvent) {
        for (Subscriber subscriber : list) {
            if (subscriber.isSuscribedTo(domainEvent)) {
                subscriber.handle(domainEvent);
            }
        }
    }
}
