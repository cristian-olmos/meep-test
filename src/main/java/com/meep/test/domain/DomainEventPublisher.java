package com.meep.test.domain;

import com.meep.test.domain.vehicle.VehicleWasAdded;

import java.util.ArrayList;
import java.util.List;

public class DomainEventPublisher {

    private static List<Subscriber> subscribers;

    private static DomainEventPublisher domainEventPublisher;

    public static DomainEventPublisher getInstance() {
        if (domainEventPublisher == null) {
            domainEventPublisher = new DomainEventPublisher();
        }
        return domainEventPublisher;
    }

    public DomainEventPublisher() {
        subscribers = new ArrayList<>();
    }

    public static void subscribe(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void publish(DomainEvent domainEvent) {
        for (Subscriber subscriber : subscribers) {
            if (subscriber.isSuscribedTo(domainEvent)) {
                subscriber.handle(domainEvent);
            }
        }
    }
}
