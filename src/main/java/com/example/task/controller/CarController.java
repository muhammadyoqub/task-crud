package com.example.task.controller;

import com.example.task.payload.ReqCar;
import com.example.task.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    CarService carService;

    // endpoint for inserting data
    @PostMapping
    public HttpEntity<?> addCar(@RequestBody ReqCar request) {
        return ResponseEntity.status(201).body(carService.addCar(request));
    }

    //endpoint for searching by car's name or manufacturer
    @GetMapping("/{word}")
    public HttpEntity<?> search(@PathVariable("word") String word) {
        return ResponseEntity.ok(carService.searchCar(word));
    }

    //endpoint for getting all data which inserted
    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }
}
