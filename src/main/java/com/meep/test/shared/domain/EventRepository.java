package com.meep.test.shared.domain;

public interface EventRepository {
    void save(DomainEvent domainEvent);
}
