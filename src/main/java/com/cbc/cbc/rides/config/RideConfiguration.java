package com.cbc.cbc.rides.config;

import com.cbc.cbc.rides.controller.RideController;
import com.cbc.cbc.rides.repository.RideRepository;
import com.cbc.cbc.rides.service.RideService;
import com.cbc.cbc.rides.service.RideServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RideConfiguration {

    @Bean
    public RideService rideService(RideRepository rideRepository) {
        return new RideServiceImpl(rideRepository);
    }

    @Bean
    public RideController rideController(RideService rideService) {
        return new RideController(rideService);
    }
}
