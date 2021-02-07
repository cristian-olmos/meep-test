package com.meep.test.domain;

public interface Subscriber {

    boolean isSuscribedTo(DomainEvent vehicleWasAdded);

    void handle(DomainEvent vehicleWasAdded);
}
