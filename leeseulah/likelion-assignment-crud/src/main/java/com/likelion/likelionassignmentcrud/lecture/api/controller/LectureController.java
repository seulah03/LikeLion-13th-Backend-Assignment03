package com.likelion.likelionassignmentcrud.lecture.api.controller;

import com.likelion.likelionassignmentcrud.lecture.api.dto.request.LectureRequestDto;
import com.likelion.likelionassignmentcrud.lecture.api.dto.response.LectureResponseDto;
import com.likelion.likelionassignmentcrud.student.api.dto.response.StudentResponseDto;
import com.likelion.likelionassignmentcrud.lecture.application.LectureService;
import com.likelion.likelionassignmentcrud.student.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lectures")
@RequiredArgsConstructor
public class LectureController {

    private final LectureService lectureService;
    private final StudentService studentService;

    @PostMapping
    public Long createLecture(@RequestBody LectureRequestDto requestDto) {
        return lectureService.createLecture(requestDto);
    }

    @GetMapping
    public List<LectureResponseDto> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @GetMapping("/{id}")
    public LectureResponseDto getLecture(@PathVariable Long id) {
        return lectureService.getLecture(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLecture(@PathVariable Long id) {
        lectureService.deleteLecture(id);
    }

    @GetMapping("/{id}/students")
    public List<StudentResponseDto> getStudentsByLecture(@PathVariable Long id) {
        return studentService.getStudentsByLectureId(id);
    }
}
