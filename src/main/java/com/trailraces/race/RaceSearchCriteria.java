package com.trailraces.race;

import jakarta.validation.constraints.DecimalMin;

@ValidDistanceRange
public record RaceSearchCriteria(

        String search,

        @DecimalMin(
                value = "0.0",
                message = "must be greater than or equal to 0"
        )
        Double distanceFrom,

        @DecimalMin(
                value = "0.0",
                message = "must be greater than or equal to 0"
        )
        Double distanceTo
) {
}