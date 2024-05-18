package com.udacity.jwdnd.c2.pricingservice.repositories;

import com.udacity.jwdnd.c2.pricingservice.entities.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {
}
