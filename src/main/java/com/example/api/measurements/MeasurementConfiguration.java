package com.example.api.measurements;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class MeasurementConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(MeasurementRepository measurementRepository) {
        return args -> measurementRepository.saveAll(List.of(
                new Measurement("Alex", "alex@email.com", LocalDate.of(2000, Month.APRIL, 3)),
                new Measurement("Tom", "tom@email,com", LocalDate.of(2001, Month.MARCH, 30))
        ));

    }
}
