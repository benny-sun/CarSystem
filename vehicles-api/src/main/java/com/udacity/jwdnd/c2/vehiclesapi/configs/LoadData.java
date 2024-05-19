package com.udacity.jwdnd.c2.vehiclesapi.configs;

import com.udacity.jwdnd.c2.vehiclesapi.domain.Condition;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Car;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.CarRepository;
import com.udacity.jwdnd.c2.vehiclesapi.domain.car.Details;
import com.udacity.jwdnd.c2.vehiclesapi.domain.manufacturer.Manufacturer;
import com.udacity.jwdnd.c2.vehiclesapi.domain.manufacturer.ManufacturerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class LoadData {

    private final CarRepository carRepository;
    private final ManufacturerRepository manufacturerRepository;

    public LoadData(CarRepository carRepository, ManufacturerRepository manufacturerRepository) {
        this.carRepository = carRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            // create Manufacturer entities
            List<Manufacturer> manufacturers = Arrays.asList(
                    new Manufacturer(101, "Audi"),
                    new Manufacturer(102, "BMW"),
                    new Manufacturer(103, "Chevrolet"),
                    new Manufacturer(104, "Ford"),
                    new Manufacturer(105, "Honda")
            );
            manufacturerRepository.saveAll(manufacturers);

            // create Car entities
            for (int i = 1; i <= 10; i++) {
                Car car = new Car();
                car.setCondition(i % 2 == 0 ? Condition.NEW : Condition.USED);
                car.setCreatedAt(LocalDateTime.now());
                car.setModifiedAt(LocalDateTime.now());

                Details details = getDetails(manufacturers, i);

                car.setDetails(details);
                carRepository.save(car);
            }
        };
    }

    private static Details getDetails(List<Manufacturer> manufacturers, int i) {
        Details details = new Details();
        details.setManufacturer(manufacturers.get(i % manufacturers.size()));
        details.setModel("Model " + i);
        details.setMileage(10000 + i * 1000);
        details.setExternalColor("Black");
        details.setBody("sedan");
        details.setEngine("3.0L V6");
        details.setFuelType("Petrol");
        details.setModelYear(2020);
        details.setProductionYear(2020 + (i % 3));
        details.setNumberOfDoors(4);

        return details;
    }
}
