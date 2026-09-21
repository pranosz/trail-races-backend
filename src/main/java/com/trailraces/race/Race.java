package com.trailraces.race;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double distance;
    private Integer elevation;
    private String location;
    private LocalDate date;
    private BigDecimal price;
    private String currency;
    private Integer itra;
    private String description;
    private String websiteUrl;

    public Race() {
    }

    public Race(
            Long id,
            String name,
            Double distance,
            Integer elevation,
            String location,
            LocalDate date,
            BigDecimal price,
            String currency,
            Integer itra,
            String description,
            String websiteUrl
    ) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.elevation = elevation;
        this.location = location;
        this.date = date;
        this.price = price;
        this.currency = currency;
        this.itra = itra;
        this.description = description;
        this.websiteUrl = websiteUrl;
    }

    public Long getId() {
    return id;
}

public String getName() {
    return name;
}

public Double getDistance() {
    return distance;
}

public Integer getElevation() {
    return elevation;
}

public String getLocation() {
    return location;
}

public LocalDate getDate() {
    return date;
}

public BigDecimal getPrice() {
    return price;
}

public String getCurrency() {
    return currency;
}

public Integer getItra() {
    return itra;
}

public String getDescription() {
    return description;
}

public String getWebsiteUrl() {
    return websiteUrl;
}
}