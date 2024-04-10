package com.devanktu.enterpriseapplicationdevelopmentjavaee;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Student;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.StudentScore;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Subject;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.repository.StudentRepository;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.repository.StudentScoreRepository;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.repository.SubjectRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
@Service
@Transactional
public class DataInit {

    private final StudentRepository studentRepository;
    private final StudentScoreRepository studentScoreRepository;
    private final SubjectRepository subjectRepository;

    @PostConstruct
    public void initializeData()  {
        initData();
    }

    private void initData() {
        // insert student
        if(studentRepository.findAll().isEmpty()){
            studentRepository.saveAll(List.of(
                    Student.builder().code("S1").fullName("Student 1").address("Hanoi").build(),
                    Student.builder().code("S2").fullName("Student 2").address("Hanoi").build(),
                    Student.builder().code("S3").fullName("Student 3").address("Hanoi").build()
            ));
            System.out.println("create student success");
        }

        // insert subject
        if(subjectRepository.findAll().isEmpty()){
            subjectRepository.saveAll(List.of(
                    Subject.builder().code("JAVA").name("Java Programming").credit(4).build(),
                    Subject.builder().code("PHP").name("PHP Programming").credit(3).build(),
                    Subject.builder().code("WDA").name("Web Development and Applications").credit(3).build()
            ));
            System.out.println("create subject success");
        }

        // insert student score
        if(studentScoreRepository.findAll().isEmpty()){
            studentScoreRepository.saveAll(List.of(
                    StudentScore.builder()
                            .student(studentRepository.findById(1L).orElseThrow())
                            .subject(subjectRepository.findById(1L).orElseThrow())
                            .score1(8.5).score2(7.0).build()
            ));
            System.out.println("create student score success");
        }
    }

}
