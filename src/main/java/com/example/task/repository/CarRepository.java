package com.example.task.repository;

import com.example.task.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByNameContainingIgnoreCaseOrManufacturerContainingIgnoreCase(String name, String manufacturer);
}
