package com.devanktu.enterpriseapplicationdevelopmentjavaee.repository;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsByCode(String code);
}
