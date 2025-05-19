package com.likelion.likelionassignmentcrud.student.domain.repository;

import com.likelion.likelionassignmentcrud.student.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByLectureId(Long lectureId);
}
