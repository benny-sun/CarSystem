package com.udacity.jwdnd.c2.vehiclesapi.api;

import com.udacity.jwdnd.c2.vehiclesapi.services.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JacksonTester<CarResponse> json;

    @MockBean
    private CarService carService;

    @BeforeEach
    public void setup() {
        CarResponse carResponse = new CarResponse();
        carResponse.setId(1L);
        given(carService.save(any())).willReturn(carResponse);
        given(carService.findById(any())).willReturn(carResponse);
        given(carService.list()).willReturn(Collections.singletonList(carResponse));
    }

    @Test
    public void getAllCars() throws Exception {
        mockMvc.perform(get(new URI("/cars")))
                .andExpect(status().isOk());

    }

    @Test
    public void getCar() throws Exception {
        mockMvc.perform(get(new URI("/cars/1")))
                .andExpect(status().isOk());
    }

    @Test
    public void createNewCar() throws Exception {
        mockMvc.perform(post(new URI("/cars"))
                .content(json.write(new CarRequest()).getJson())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateCar() throws Exception {
        mockMvc.perform(put(new URI("/cars/1"))
                        .content(json.write(new CarRequest()).getJson())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteCar() throws Exception {
        mockMvc.perform(delete(new URI("/cars/1")))
                .andExpect(status().isNoContent());
    }
}
