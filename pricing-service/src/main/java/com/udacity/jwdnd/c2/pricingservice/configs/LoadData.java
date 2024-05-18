package com.udacity.jwdnd.c2.pricingservice.configs;

import com.udacity.jwdnd.c2.pricingservice.entities.Price;
import com.udacity.jwdnd.c2.pricingservice.repositories.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(PriceRepository repository) {
        return args -> {
            for (int i = 1; i <= 10; i++) {
                Price price = new Price(
                        "USD",
                        randomPrice(),
                        (long) i
                );
                repository.save(price);
            }
        };
    }

    private static BigDecimal randomPrice() {
        return BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1, 5))
                .multiply(new BigDecimal("5000")).setScale(2, RoundingMode.HALF_UP);
    }
}
