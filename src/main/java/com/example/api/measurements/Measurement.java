package com.example.api.measurements;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
//todo add parent abstract class with super.liquid
@Component
@Entity
public class Measurement {

    @Id
    @SequenceGenerator(name = "measurement_generator", sequenceName = "measurement_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measurement_generator")
    private Long id;

    private String username;

    @Column(name= "email")
    private String email;

    @Column(name = "timestamp")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    @Column(name = "gas_usage")
    private Double gasUsage;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getGasUsage() {
        return gasUsage;
    }

    public void setGasUsage(Double gasUsage) {
        this.gasUsage = gasUsage;
    }

    public Double getColdWaterUsage() {
        return coldWaterUsage;
    }

    public void setColdWaterUsage(Double coldWaterUsage) {
        this.coldWaterUsage = coldWaterUsage;
    }

    public Double getHotWaterUsage() {
        return hotWaterUsage;
    }

    public void setHotWaterUsage(Double hotWaterUsage) {
        this.hotWaterUsage = hotWaterUsage;
    }

    @Column(name = "cold_water_usage")
    private Double coldWaterUsage;


    @Column(name = "hot_water_usage")
    private Double hotWaterUsage;


    public Measurement() {
    }

    public Measurement(String username, String email,
                       LocalDateTime timestamp, Double gasUsage,
                       Double coldWaterUsage, Double hotWaterUsage) {
        this.username = username;
        this.email = email;
        this.timestamp = timestamp;
        this.gasUsage = gasUsage;
        this.coldWaterUsage = coldWaterUsage;
        this.hotWaterUsage = hotWaterUsage;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
