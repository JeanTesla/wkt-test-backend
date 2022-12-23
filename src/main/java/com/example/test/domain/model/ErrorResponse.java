package com.example.test.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ErrorResponse {
    private HttpStatus httpStatus;
    private String timestamp;
    private String message;
    private List<Map<String, Object>> details;

    public ErrorResponse(HttpStatus httpStatus, String message, List<Map<String, Object>> details) {
        this.httpStatus = httpStatus;
        this.timestamp = LocalDateTime.now().toString();
        this.message = message;
        this.details = details;
    }
}
