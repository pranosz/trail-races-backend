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

    public static Specification<Race> search(String search) {
        return (root, query, criteriaBuilder) -> {
            String pattern = "%" + search.toLowerCase() + "%";

            return criteriaBuilder.or(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("name")),
                            pattern
                    ),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("location")),
                            pattern
                    ),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("currency")),
                            pattern
                    ),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("description")),
                            pattern
                    ),
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("websiteUrl")),
                            pattern
                    )
            );
        };
    }
}
