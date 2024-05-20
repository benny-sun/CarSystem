package com.udacity.jwdnd.c2.vehiclesapi.api;

import com.udacity.jwdnd.c2.vehiclesapi.services.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Tag(name = "Car Controller", description = "Controller for vehicle operations")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @Operation(summary = "Get all cars", description = "Creates a list to store any vehicles.")
    public List<CarResponse> list() {
        return carService.list();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get car info by ID", description = "Gets information of a specific car by ID.")
    public CarResponse get(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a car information", description = "Posts information to create a new vehicle in the system.")
    public CarResponse create(@RequestBody CarRequest request) {
        return carService.save(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit car by ID", description = "Updates the information of a vehicle in the system.")
    public CarResponse update(@PathVariable Long id, @RequestBody CarRequest request) {
        carService.findById(id); // check if car exist
        request.setId(id);
        return carService.save(request);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete car by ID", description = "Removes a vehicle from the system.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}
