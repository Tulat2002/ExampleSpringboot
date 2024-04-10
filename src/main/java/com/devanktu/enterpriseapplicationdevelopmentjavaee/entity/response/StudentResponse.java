package com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.response;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Student;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Subject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private Long id;
    private Double score1;
    private Double score2;
    private Student student;
    private Subject subject;
    private String grade;
}