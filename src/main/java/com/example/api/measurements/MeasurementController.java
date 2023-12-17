package com.example.api.measurements;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/measurements")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping(path="list")
    public List<Measurement> measurements() {
        return measurementService.list();
    }

    @GetMapping(path="listAll/{username}")
    public List<Measurement> measurements(@PathVariable String username) {
        return measurementService.listAll(username);
    }

    @PostMapping(path="item")
    public List<Measurement> add(@RequestBody Measurement measurement) {
        measurementService.add(measurement);
        return measurementService.list();
    }

    @DeleteMapping(path="item/{measurementId}")
    public void delete(@PathVariable Long measurementId) {
        measurementService.delete(measurementId);
    }

    @PutMapping(path="item")
    public void update(@RequestBody Measurement measurement) {
        measurementService.update(measurement);
    }
}
