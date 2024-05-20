package com.udacity.jwdnd.c2.vehiclesapi.clients.maps;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "boogle-maps", url = "localhost:9191")
public interface MapsClient {
    @GetMapping("/maps")
    Address getLocation(@RequestParam Double lat, @RequestParam Double lon);
}
