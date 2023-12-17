package com.example.api.measurements;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Entity
public class Measurement {

    @Id
    @SequenceGenerator(name = "measurement_generator", sequenceName = "measurement_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "measurement_generator")
    private Long id;

    private String username;

    @Column(unique = true)
    private String email;
    private LocalDate paymentDay;

//    @Column(name = "timestamp")
//    private LocalDateTime timestamp;
//
//    @Column(name = "gas_usage")
//    private Double gasUsage;
//
//    @Column(name = "cold_water_usage")
//    private Double coldWaterUsage;
//
//    @Column(name = "hot_water_usage")
//    private Double hotWaterUsage;
//

    public Measurement() {
    }

    public Measurement(String username, String email, LocalDate paymentDay) {
        this.username = username;
        this.email = email;
        this.paymentDay = paymentDay;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getPaymentDay() {
        return paymentDay;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPaymentDay(LocalDate dob) {
        this.paymentDay = dob;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", name='" + username + '\'' +
                ", email='" + email + '\'' +
                ", paymentDay=" + paymentDay +
                '}';
    }
}
