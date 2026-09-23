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
            Pageable pageable) {

        if (search == null || search.isBlank()) {
            return raceService.getAllRaces(pageable);
        }

        return raceService.searchRaces(search, pageable);
    }
}