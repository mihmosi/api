package com.example.api.configuratins;

import com.example.api.measurements.Measurement;
import com.example.api.measurements.MeasurementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class MeasurementConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(MeasurementRepository measurementRepository) {
        return args -> measurementRepository.saveAll(List.of(
                new Measurement("Alex", "alex@email.com", LocalDateTime.of(2023, 12,
                        17, 12, 0), 5.0, 3.0, 2.0),
                new Measurement("Tom", "tom@email.com", LocalDateTime.of(2023, 12,
                        16, 23, 0), 4.0, 4.0, 1.0)
        ));

    }
}
