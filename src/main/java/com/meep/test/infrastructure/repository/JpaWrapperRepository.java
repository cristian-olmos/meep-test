package com.meep.test.infrastructure.repository;

import com.meep.test.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaWrapperRepository extends JpaRepository<Vehicle, String> {
}
