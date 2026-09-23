package com.trailraces.race;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DistanceRangeValidator
        implements ConstraintValidator<ValidDistanceRange, RaceSearchCriteria> {

    @Override
    public boolean isValid(
            RaceSearchCriteria criteria,
            ConstraintValidatorContext context) {

        if (criteria == null) {
            return true;
        }

        if (criteria.distanceFrom() == null
                || criteria.distanceTo() == null) {
            return true;
        }

        return criteria.distanceFrom() <= criteria.distanceTo();
    }
}