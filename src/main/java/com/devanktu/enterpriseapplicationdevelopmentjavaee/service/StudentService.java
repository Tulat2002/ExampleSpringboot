package com.devanktu.enterpriseapplicationdevelopmentjavaee.service;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.dto.StudentDto;

public interface StudentService {

    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentById(Long id);

    StudentDto updateStudent(StudentDto studentDto, Long id);

    void deleteStudentId(Long id);

}
