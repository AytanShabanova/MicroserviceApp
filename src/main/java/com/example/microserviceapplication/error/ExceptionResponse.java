package com.example.microserviceapplication.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private Integer code;
    private String message;

}
