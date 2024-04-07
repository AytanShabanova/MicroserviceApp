package com.example.microserviceapplication.mapper;

import com.example.microserviceapplication.dto.request.CreateStudentRequest;
import com.example.microserviceapplication.dto.request.UpdateStudentRequest;
import com.example.microserviceapplication.dto.response.StudentResponse;
import com.example.microserviceapplication.model.Student;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-28T11:58:57-0800",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public Student mapRequestToStudent(CreateStudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return null;
        }

        Student student = new Student();

        student.setName( studentRequest.getName() );
        student.setSurName( studentRequest.getSurName() );
        student.setGroupName( studentRequest.getGroupName() );

        return student;
    }

    @Override
    public StudentResponse mapEntityToResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId( student.getId() );
        studentResponse.setName( student.getName() );
        studentResponse.setSurName( student.getSurName() );
        studentResponse.setGroupName( student.getGroupName() );

        return studentResponse;
    }

    @Override
    public Student mapUpdateRequestToEntity(Student student, UpdateStudentRequest request) {
        if ( request == null ) {
            return student;
        }

        if ( request.getName() != null ) {
            student.setName( request.getName() );
        }
        if ( request.getSurName() != null ) {
            student.setSurName( request.getSurName() );
        }
        if ( request.getGroupName() != null ) {
            student.setGroupName( request.getGroupName() );
        }

        return student;
    }
}
