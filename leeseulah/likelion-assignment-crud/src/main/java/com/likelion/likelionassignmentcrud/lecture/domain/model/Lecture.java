package com.likelion.likelionassignmentcrud.lecture.domain.model;

import com.likelion.likelionassignmentcrud.student.domain.model.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String instructor;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public Lecture(String title, String instructor) {
        this.title = title;
        this.instructor = instructor;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setLecture(this);
    }
}
