package com.likelion.likelionassignmentcrud.student.application;

import com.likelion.likelionassignmentcrud.student.api.dto.request.StudentRequestDto;
import com.likelion.likelionassignmentcrud.student.api.dto.response.StudentResponseDto;
import com.likelion.likelionassignmentcrud.lecture.domain.model.Lecture;
import com.likelion.likelionassignmentcrud.student.domain.model.Student;
import com.likelion.likelionassignmentcrud.lecture.domain.repository.LectureRepository;
import com.likelion.likelionassignmentcrud.student.domain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    public Long createStudent(StudentRequestDto requestDto) {
        Lecture lecture = lectureRepository.findById(requestDto.getLectureId())
                .orElseThrow(() -> new IllegalArgumentException("해당 강의가 존재하지 않습니다."));

        Student student = new Student(requestDto.getName(), requestDto.getEmail());
        student.setLecture(lecture);
        return studentRepository.save(student).getId();
    }

    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> getStudentsByLectureId(Long lectureId) {
        return studentRepository.findByLectureId(lectureId).stream()
                .map(StudentResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
