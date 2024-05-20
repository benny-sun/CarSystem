package com.udacity.jwdnd.c2.vehiclesapi.services;

import com.udacity.jwdnd.c2.vehiclesapi.api.CarResponse;
import com.udacity.jwdnd.c2.vehiclesapi.clients.pricing.Price;
import com.udacity.jwdnd.c2.vehiclesapi.clients.pricing.PriceClient;
import com.udacity.jwdnd.c2.vehiclesapi.clients.pricing.PriceResponse;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Car;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.CarRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository repository;
    private final PriceClient priceClient;

    public CarService(CarRepository repository, PriceClient priceClient) {
        this.repository = repository;
        this.priceClient = priceClient;
    }

    public List<CarResponse> list() {
        List<Car> cars = repository.findAll();
        PriceResponse priceResponse = priceClient.getAllPrices();
        List<Price> prices = priceResponse.get_embedded().getPrices();
        Map<Long, BigDecimal> priceMap = prices.stream()
                .collect(Collectors.toMap(Price::getVehicleId, Price::getPrice));

        return cars.stream()
                .map(car -> new CarResponse(car, priceMap.get(car.getId())))
                .collect(Collectors.toList());
    }

    public CarResponse findById(Long id) {
        Car car = repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        Price price = priceClient.getPrice(id);

        return new CarResponse(car, price.getPrice());
    }

    public Car save(Car car) {
        return repository.save(car);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
