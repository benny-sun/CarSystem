package com.udacity.jwdnd.c2.vehiclesapi.clients.pricing;

import java.math.BigDecimal;

public class Price {
    private String currency;
    private BigDecimal price;
    private Long vehicleId;

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
