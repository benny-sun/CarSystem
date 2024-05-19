package com.udacity.jwdnd.c2.vehiclesapi.clients.pricing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceResponse {

    private Embedded _embedded;

    public Embedded get_embedded() {
        return _embedded;
    }

    public void set_embedded(Embedded _embedded) {
        this._embedded = _embedded;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Embedded {
        private List<Price> prices;

        public List<Price> getPrices() {
            return prices;
        }

        public void setPrices(List<Price> prices) {
            this.prices = prices;
        }
    }
}
