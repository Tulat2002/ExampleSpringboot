package com.devanktu.enterpriseapplicationdevelopmentjavaee.controller;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Student;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.request.CreateStudent;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.request.CreateStudentScore;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.request.CreateSubject;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.service.StudentService;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.service.impl.StudentServiceImpl;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceImpl studentService;

    @GetMapping
    public ResponseEntity<?> getStudentInfo(@Nullable Long id){
        return studentService.getStudentInfo(id);
    }
    // create student api
    @PostMapping("/create-student")
    public ResponseEntity<?> createStudent(@Valid CreateStudent data){
        return studentService.createStudent(data);
    }
    // create subject api
    @PostMapping("/create-subject")
    public ResponseEntity<?> createSubject(@Valid CreateSubject data){
        return studentService.createSubject(data);
    }
    // create student score api
    @PostMapping("/create-student-score")
    public ResponseEntity<?> createStudentScore(@Valid CreateStudentScore data){
        return studentService.createStudentScore(data);
    }
}
