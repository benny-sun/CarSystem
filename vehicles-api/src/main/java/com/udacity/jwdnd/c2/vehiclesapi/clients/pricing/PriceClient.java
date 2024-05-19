package com.udacity.jwdnd.c2.vehiclesapi.clients.pricing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pricing-service", url = "localhost:8762")
public interface PriceClient {
    @GetMapping("/prices/{id}")
    Price getPrice(@PathVariable("id") Long id);

    @GetMapping("/prices")
    PriceResponse getAllPrices();
}