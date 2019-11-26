package com.example.task.service;

import com.example.task.payload.ApiResponse;
import com.example.task.payload.ReqCar;

public interface CarInterface {
    ApiResponse addCar(ReqCar reqest);

    ApiResponse searchCar(String searchWord);

    ApiResponse getAll();
}
