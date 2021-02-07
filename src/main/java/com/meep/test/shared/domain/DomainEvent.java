package com.meep.test.shared.domain;

import java.time.Instant;
import java.util.UUID;

public abstract class DomainEvent {
    private Instant ocurredOn;
    private String id;

    public DomainEvent() {
        this.ocurredOn = Instant.now();
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "DomainEvent{" +
                "ocurredOn=" + ocurredOn +
                ", id='" + id + '\'' +
                '}';
    }
}
