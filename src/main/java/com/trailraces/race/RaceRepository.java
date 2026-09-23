package com.trailraces.race;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RaceRepository
        extends JpaRepository<Race, Long>, JpaSpecificationExecutor<Race> {
}