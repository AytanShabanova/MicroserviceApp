package com.example.microserviceapplication.service;

import com.example.microserviceapplication.dto.request.CreateStudentRequest;
import com.example.microserviceapplication.dto.response.StudentResponse;
import com.example.microserviceapplication.error.StudentNotFoundException;
import com.example.microserviceapplication.mapper.StudentMapper;
import com.example.microserviceapplication.repository.StudentRepository;
import com.example.microserviceapplication.dto.request.UpdateStudentRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    public void createStudent(CreateStudentRequest studentRequest){
        studentRepository.save(studentMapper.mapRequestToStudent(studentRequest));
    }
    public List<StudentResponse> getAllStudents(){

          return  studentRepository.findAll().stream().map(studentMapper::mapEntityToResponse).collect(Collectors.toList());
    }
    public StudentResponse getStudent(Long id){
      var student=   studentRepository.findById(id).orElseThrow(this::exStudentNotFound);

    return studentMapper.mapEntityToResponse(student);

    }
    public void updateStudent(Long id, UpdateStudentRequest updateRequest){
 var student=studentRepository
         .findById(id).orElseThrow(this::exStudentNotFound);
 studentMapper.mapUpdateRequestToEntity(student,updateRequest);
 studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        var student=studentRepository.findById(id).orElseThrow(this::exStudentNotFound);
        studentRepository.deleteById(id);
    }
    public StudentNotFoundException exStudentNotFound() {
        throw new StudentNotFoundException();
    }
}
