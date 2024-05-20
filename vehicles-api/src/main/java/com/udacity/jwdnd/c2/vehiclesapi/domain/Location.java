package com.udacity.jwdnd.c2.vehiclesapi.domain;

import com.udacity.jwdnd.c2.vehiclesapi.clients.maps.Address;

public class Location {

    private final Double lat;
    private final Double lon;
    private final String address;
    private final String city;
    private final String state;
    private final String zip;

    public Location(Double lat, Double lon, Address address) {
        this.lat = lat;
        this.lon = lon;
        this.address = address.getAddress();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
