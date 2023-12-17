package com.example.api.measurements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    Optional<Measurement> findStudentByEmail(String email);
   List<Measurement> findByUsername(String username);
}
