package com.devanktu.enterpriseapplicationdevelopmentjavaee.service.impl;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.dto.StudentDto;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Student;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.StudentScore;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.Subject;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.request.CreateStudent;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.request.CreateStudentScore;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.request.CreateSubject;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.exception.StudentNotFoundException;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.repository.StudentRepository;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.repository.StudentScoreRepository;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.repository.SubjectRepository;
import com.devanktu.enterpriseapplicationdevelopmentjavaee.service.StudentService;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl {

    private final StudentRepository studentRepository;
    private final StudentScoreRepository studentScoreRepository;
    private final SubjectRepository subjectRepository;


    public ResponseEntity<?> createStudent(CreateStudent data){
        try {
            // check if student code is already exists
            if(studentRepository.existsByCode(data.getCode())){
                return ResponseEntity.badRequest().body("Student code is already exists");
            }
            var student = studentRepository.save(
                    Student.builder()
                            .code(data.getCode())
                            .fullName(data.getFullName())
                            .address(data.getAddress())
                            .build()
            );
            return ResponseEntity.ok(student);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    public ResponseEntity<?> createSubject(CreateSubject data){
        try {
            // check if subject code or name is already exists
            if(subjectRepository.existsByCodeOrName(data.getCode(),data.getName())){
                return ResponseEntity.badRequest().body("Subject code is already exists");
            }
            var subject = subjectRepository.save(
                    Subject.builder()
                            .code(data.getCode())
                            .name(data.getName())
                            .credit(data.getCredit())
                            .build()
            );
            return ResponseEntity.ok(subject);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    public ResponseEntity<?> createStudentScore(CreateStudentScore data){
        try {
            var student = studentRepository.findById(data.getStudentId()).orElseThrow(
                    () -> new Exception("Student not found by id: "+data.getStudentId())
            );
            var subject = subjectRepository.findById(data.getSubjectId()).orElseThrow(
                    () -> new Exception("Subject not found by id: "+data.getStudentId())
            );
            var studentScore = studentScoreRepository.save(
                    com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.StudentScore.builder()
                            .student(student)
                            .subject(subject)
                            .score1(data.getScore1())
                            .score2(data.getScore2())
                            .build()
            );
            return ResponseEntity.ok(studentScore);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //

    public ResponseEntity<?> getStudentInfo(@Nullable Long id){
        try {
            if(id!=null){
                var student = studentScoreRepository.findByStudent_Id(id).orElseThrow(
                        () -> new Exception("Student not found by id: "+id)
                );
                return ResponseEntity.ok(student.convertFrom());
            }
            var students = studentScoreRepository.findAll().stream().map(StudentScore::convertFrom).toList();
            return ResponseEntity.ok(students);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
