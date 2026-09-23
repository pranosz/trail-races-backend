package com.trailraces.race;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaceController {

    private final RaceService raceService;

    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/api/races")
    public Page<Race> getRaces(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Double distanceFrom,
            @RequestParam(required = false) Double distanceTo,
            Pageable pageable) {

        return raceService.getRaces(
                search,
                distanceFrom,
                distanceTo,
                pageable
        );
    }
}