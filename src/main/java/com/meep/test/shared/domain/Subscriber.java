package com.meep.test.shared.domain;

public interface Subscriber {

    boolean isSuscribedTo(DomainEvent vehicleWasAdded);

    void handle(DomainEvent vehicleWasAdded);
}
