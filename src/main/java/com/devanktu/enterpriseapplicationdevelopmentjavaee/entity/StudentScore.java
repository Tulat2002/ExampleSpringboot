package com.devanktu.enterpriseapplicationdevelopmentjavaee.entity;

import com.devanktu.enterpriseapplicationdevelopmentjavaee.entity.response.StudentResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_core")
public class StudentScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "decimal(5,2)")
    private Double score1;
    @Column(columnDefinition = "decimal(5,2)")
    private Double score2;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonManagedReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonManagedReference
    private Subject subject;

    @JsonIgnore
    public StudentResponse convertFrom(){
        return StudentResponse.builder()
                .id(this.id)
                .score1(this.score1)
                .score2(this.score2)
                .student(this.student)
                .subject(this.subject)
                .grade(getGrade())
                .build();
    }
    @JsonIgnore
    private String getGrade(){
        double avg = (0.3*this.score1 + 0.7 * this.score2);
        if(avg >= 8.0){
            return "A";
        }else if(avg < 8.0 && avg >= 6.0){
            return "B";
        }else if(avg < 6 && avg >= 4){
            return "B";
        }
        return "F";
    }
}