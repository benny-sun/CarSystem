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

    public CarResponse() {

    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
