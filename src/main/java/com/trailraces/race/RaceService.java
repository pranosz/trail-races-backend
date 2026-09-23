package com.trailraces.race;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    private final RaceRepository raceRepository;

    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public Page<Race> getAllRaces(Pageable pageable) {
        return raceRepository.findAll(pageable);
    }

    public Page<Race> searchRaces(String search, Pageable pageable) {
        return raceRepository.search(search, pageable);
    }
}