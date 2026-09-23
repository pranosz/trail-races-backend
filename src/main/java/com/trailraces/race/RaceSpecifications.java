package com.trailraces.race;

import org.springframework.data.jpa.domain.Specification;

public final class RaceSpecifications {

    private RaceSpecifications() {
    }

    public static Specification<Race> distanceFrom(Double distanceFrom) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(
                        root.get("distance"),
                        distanceFrom
                );
    }

    public static Specification<Race> distanceTo(Double distanceTo) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(
                        root.get("distance"),
                        distanceTo
                );
    }
}
