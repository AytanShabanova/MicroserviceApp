package com.example.microserviceapplication.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequest {
    @NotBlank(message = "error.emptyName")
    @Email
    private String name;
    @NotBlank(message = "error.emptySurname")
    private String surName;
    @NotBlank(message = "error.emptyGroupName")
    private  String groupName;

}
