package com.likelion.likelionassignmentcrud.student.domain.model;

import com.likelion.likelionassignmentcrud.lecture.domain.model.Lecture;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
}
