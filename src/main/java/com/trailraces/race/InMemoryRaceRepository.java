package com.trailraces.race;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public class InMemoryRaceRepository implements RaceRepository {

    @Override
    public List<Race> findAll() {

        Race race1 = new Race(
                1L,
                "Tatry Ultra",
                50.0,
                2800,
                "Zakopane",
                LocalDate.of(2026, 8, 15),
                new BigDecimal("250.00"),
                "PLN",
                2,
                "Mountain ultra race in the Tatra Mountains",
                "https://example.com/tatry-ultra"
        );

        Race race2 = new Race(
                2L,
                "Beskidy Trail",
                30.0,
                1500,
                "Szczyrk",
                LocalDate.of(2026, 9, 20),
                new BigDecimal("180.00"),
                "PLN",
                1,
                "Trail race in the Beskid Mountains",
                "https://example.com/beskidy-trail"
        );

        return List.of(race1, race2);
    }
}
