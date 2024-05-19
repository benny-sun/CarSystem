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
    public List<Car> list() {
        return carService.list();
    }

    @GetMapping("/{id}")
    public Car get(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.save(car);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Long id, @RequestBody Car car) {
        carService.findById(id); // check if car exist
        car.setId(id);
        return carService.save(car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}
