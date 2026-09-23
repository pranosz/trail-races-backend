package com.trailraces.race;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

@RestController
@Validated
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/api/races")
    public Page<Race> getRaces(
            @Valid RaceSearchCriteria criteria,
            Pageable pageable) {

        return raceService.getRaces(
                criteria.search(),
                criteria.distanceFrom(),
                criteria.distanceTo(),
                pageable
        );
    }
}