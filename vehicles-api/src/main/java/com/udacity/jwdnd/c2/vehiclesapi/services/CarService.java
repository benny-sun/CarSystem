package com.udacity.jwdnd.c2.vehiclesapi.services;

import com.udacity.jwdnd.c2.vehiclesapi.api.CarRequest;
import com.udacity.jwdnd.c2.vehiclesapi.api.CarResponse;
import com.udacity.jwdnd.c2.vehiclesapi.clients.maps.Address;
import com.udacity.jwdnd.c2.vehiclesapi.domain.Location;
import com.udacity.jwdnd.c2.vehiclesapi.clients.maps.MapsClient;
import com.udacity.jwdnd.c2.vehiclesapi.clients.pricing.Price;
import com.udacity.jwdnd.c2.vehiclesapi.clients.pricing.PriceClient;
import com.udacity.jwdnd.c2.vehiclesapi.clients.pricing.PriceResponse;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Car;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.CarRepository;
import feign.FeignException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository repository;
    private final PriceClient priceClient;
    private final MapsClient mapsClient;

    public CarService(CarRepository repository, PriceClient priceClient, MapsClient mapsClient) {
        this.repository = repository;
        this.priceClient = priceClient;
        this.mapsClient = mapsClient;
    }

    public List<CarResponse> list() {
        List<Car> cars = repository.findAll();
        PriceResponse priceResponse = priceClient.getAllPrices();
        List<Price> prices = priceResponse.get_embedded().getPrices();
        Map<Long, BigDecimal> priceMap = prices.stream()
                .collect(Collectors.toMap(Price::getVehicleId, Price::getPrice));

        return cars.stream()
                .map(car -> new CarResponse(car, priceMap.get(car.getId()), getMockLocation()))
                .collect(Collectors.toList());
    }

    public CarResponse findById(Long id) {
        Car car = repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        Price price = priceClient.getPrice(id);

        return new CarResponse(car, price.getPrice(), getMockLocation());
    }

    public CarResponse save(CarRequest carRequest) {
        Car car = new Car();
        car.setId(carRequest.getId());
        car.setCondition(carRequest.getCondition());
        car.setDetails(carRequest.getDetails());
        Car savedCar = repository.save(car);

        Price price = new Price();
        price.setVehicleId(savedCar.getId());
        price.setPrice(carRequest.getPrice());
        price.setCurrency("USD");

        Price savedPrice = carRequest.getId() == null
                ? priceClient.createPrice(price)
                : priceClient.updatePrice(savedCar.getId(), price);

        return new CarResponse(savedCar, savedPrice.getPrice(), getMockLocation());
    }

    private Location getMockLocation() {
        Random random = new Random();
        Double lat = -90.0 + 180.0 * random.nextDouble(); // Latitude range: -90 to 90
        Double lon = -180.0 + 360.0 * random.nextDouble(); // Longitude range: -180 to 180
        Address address = mapsClient.getLocation(lat, lon);

        return new Location(lat, lon, address);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        try {
            priceClient.delete(id);
        } catch (FeignException.NotFound e) {
            throw new CarNotFoundException(id);
        }
    }
}
