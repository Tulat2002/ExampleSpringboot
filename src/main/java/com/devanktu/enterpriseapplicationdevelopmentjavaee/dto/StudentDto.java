package com.devanktu.enterpriseapplicationdevelopmentjavaee.dto;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.StudentScore;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long studentId;

    private String studentCode;

    private String fullName;

    private String address;

    private List<StudentScore> studentScores;

}
