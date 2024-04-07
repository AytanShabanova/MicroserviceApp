package com.example.microserviceapplication.mapper;

import com.example.microserviceapplication.dto.request.CreateStudentRequest;
import com.example.microserviceapplication.dto.request.UpdateStudentRequest;
import com.example.microserviceapplication.dto.response.StudentResponse;
import com.example.microserviceapplication.model.Student;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE,nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public interface StudentMapper {
    @Mapping(target = "id",ignore = true)
    Student mapRequestToStudent(CreateStudentRequest studentRequest);
    StudentResponse mapEntityToResponse(Student student);

    Student mapUpdateRequestToEntity(@MappingTarget Student student, UpdateStudentRequest request);

}
