package com.trailraces.race;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RaceRepository extends JpaRepository<Race, Long>, JpaSpecificationExecutor<Race> {

    @Query("""
        SELECT r
        FROM Race r
        WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :search, '%'))
           OR LOWER(r.location) LIKE LOWER(CONCAT('%', :search, '%'))
           OR LOWER(r.currency) LIKE LOWER(CONCAT('%', :search, '%'))
           OR LOWER(r.description) LIKE LOWER(CONCAT('%', :search, '%'))
           OR LOWER(r.websiteUrl) LIKE LOWER(CONCAT('%', :search, '%'))
        """)
    Page<Race> search(@Param("search") String search, Pageable pageable);
}
