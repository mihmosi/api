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

    // TODO add more validation
    public void add(Measurement measurement) {
        if (measurement.getGasUsage() < 0 || measurement.getHotWaterUsage() < 0 || measurement.getColdWaterUsage() < 0) {
            throw new RestApiException("Data not valid");
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
            if (measurement.getGasUsage() != null) {
                item.setGasUsage(measurement.getGasUsage());
            } // todo add more edit
            measurementRepository.save(item);
        }

    }
}


