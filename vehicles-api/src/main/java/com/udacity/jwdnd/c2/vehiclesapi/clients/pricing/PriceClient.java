package com.udacity.jwdnd.c2.vehiclesapi.clients.pricing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "pricing-service", url = "localhost:8762")
public interface PriceClient {
    @GetMapping("/prices/{id}")
    Price getPrice(@PathVariable("id") Long id);

    @GetMapping("/prices")
    PriceResponse getAllPrices();

    @PostMapping("/prices")
    Price createPrice(@RequestBody Price price);

    @PutMapping("/prices/{id}")
    Price updatePrice(@PathVariable("id") Long id, @RequestBody Price price);

    @DeleteMapping("/prices/{id}")
    void delete(@PathVariable("id") Long id);
}