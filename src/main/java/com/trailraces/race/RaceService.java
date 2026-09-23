package com.trailraces.race;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    public Page<Race> getRaces(
            Double distanceFrom,
            Double distanceTo,
            Pageable pageable) {

        Specification<Race> specification = null;

        if (distanceFrom != null) {
            specification = RaceSpecifications.distanceFrom(distanceFrom);
        }

        if (distanceTo != null) {
            Specification<Race> distanceToSpecification =
                    RaceSpecifications.distanceTo(distanceTo);

            specification = specification == null
                    ? distanceToSpecification
                    : specification.and(distanceToSpecification);
        }

        if (specification == null) {
            return raceRepository.findAll(pageable);
        }

        return raceRepository.findAll(specification, pageable);
    }
}