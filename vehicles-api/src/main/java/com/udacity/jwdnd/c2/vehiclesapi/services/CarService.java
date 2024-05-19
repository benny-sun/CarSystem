package com.udacity.jwdnd.c2.vehiclesapi.services;

import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Car;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> list() {
        return repository.findAll();
    }

    public Car findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    public Car save(Car car) {
        return repository.save(car);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
