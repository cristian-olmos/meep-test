package com.meep.test.domain;

public interface EventRepository {
    void save(DomainEvent domainEvent);
}
