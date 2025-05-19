package com.likelion.likelionassignmentcrud.lecture.domain.repository;

import com.likelion.likelionassignmentcrud.lecture.domain.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
