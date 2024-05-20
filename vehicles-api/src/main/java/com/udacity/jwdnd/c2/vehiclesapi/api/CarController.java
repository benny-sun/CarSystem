package com.udacity.jwdnd.c2.vehiclesapi.api;

import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Car;
import com.udacity.jwdnd.c2.vehiclesapi.services.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarResponse> list() {
        return carService.list();
    }

    @GetMapping("/{id}")
    public CarResponse get(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public CarResponse create(@RequestBody CarRequest request) {
        return carService.save(request);
    }

    @PutMapping("/{id}")
    public CarResponse update(@PathVariable Long id, @RequestBody CarRequest request) {
        carService.findById(id); // check if car exist
        request.setId(id);
        return carService.save(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}
