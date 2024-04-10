package com.devanktu.enterpriseapplicationdevelopmentjavaee.repository;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.StudentScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentScoreRepository extends JpaRepository<StudentScore, Long> {
    Optional<StudentScore> findByStudent_Id(Long studentId);
}
