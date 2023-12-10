package com.example.api.students;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
@Entity
public class Student {

    @Id
    @SequenceGenerator(name = "student_generator", sequenceName = "student_generator")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    private Long id;

    private String name;
    private LocalDate dob;

    public Student() {
    }

    public Student(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dbd=" + dob +
                '}';
    }
}
