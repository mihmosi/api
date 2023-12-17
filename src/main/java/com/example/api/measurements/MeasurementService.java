package com.example.api.measurements;

import com.example.api.responce.RestApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    private final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    public List<Measurement> list() {
        return measurementRepository.findAll();
    }

    public List<Measurement> listAll(String userName) {
        return measurementRepository.findByUsername(userName);
    }

    public void add(Measurement measurement) {
        if (measurementRepository.findStudentByEmail(measurement.getEmail()).isPresent()) {
            throw new RestApiException("Email is busy");
        }
        measurementRepository.save(measurement);
    }

    public void delete(Long measurementId) {
        measurementRepository.deleteById(measurementId);
    }

    public void update(Measurement measurement) {
        Optional<Measurement> row = measurementRepository.findById(measurement.getId());
        if (row.isPresent()) {
            Measurement item = row.get();
            if (!measurement.getUsername().isEmpty()) {
                item.setUsername(measurement.getUsername());
            }
            if (measurement.getPaymentDay() != null) {
                item.setPaymentDay(measurement.getPaymentDay());
            }
            measurementRepository.save(item);
        }

    }
}
