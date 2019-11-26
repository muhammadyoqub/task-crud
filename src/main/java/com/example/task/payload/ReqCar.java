package com.example.task.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class ReqCar {
    private String name, manufacturer;
    private Timestamp productionDate;
}
