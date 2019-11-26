package com.example.task.service;

import com.example.task.entity.Car;
import com.example.task.payload.ApiResponse;
import com.example.task.payload.ReqCar;
import com.example.task.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CarService implements CarInterface {
    @Autowired
    private CarRepository carRepository;

    @Override
    public ApiResponse addCar(ReqCar request) {
        try {
            Car car = new Car(request.getName(), request.getManufacturer(), request.getProductionDate());
            carRepository.save(car);
            return new ApiResponse(true, "Saved successfully");
        } catch (Exception e) {
            return new ApiResponse(true, "Something went wrong");
        }
    }

    @Override
    public ApiResponse searchCar(String searchWord) {
        return new ApiResponse(true, carRepository.findAllByNameContainingIgnoreCaseOrManufacturerContainingIgnoreCase(searchWord, searchWord)
                .stream().map(this::get).collect(Collectors.toList()));
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse(true, carRepository.findAll().stream().map(this::get).collect(Collectors.toList()));
    }

    private ReqCar get(Car car) {
        return new ReqCar(car.getName(), car.getManufacturer(), car.getProductionDate());
    }
}
