package com.devanktu.enterpriseapplicationdevelopmentjavaee.repository;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    boolean existsByCodeOrName(String code, String name);
}
