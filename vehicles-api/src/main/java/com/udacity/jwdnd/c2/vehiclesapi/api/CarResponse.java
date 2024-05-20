package com.udacity.jwdnd.c2.vehiclesapi.api;

import com.udacity.jwdnd.c2.vehiclesapi.domain.Condition;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Car;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Details;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarResponse {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private Condition condition;
    private Details details;
    private BigDecimal price;

    public CarResponse(Car car, String price) {
    public CarResponse(Car car, BigDecimal price) {
        this.id = car.getId();
        this.createdAt = car.getCreatedAt();
        this.modifiedAt = car.getModifiedAt();
        this.condition = car.getCondition();
        this.details = car.getDetails();
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public Condition getCondition() {
        return condition;
    }

    public Details getDetails() {
        return details;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
