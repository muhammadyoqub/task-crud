package com.example.task.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object object;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, Object object) {
        this.success = success;
        this.object = object;
    }
}
