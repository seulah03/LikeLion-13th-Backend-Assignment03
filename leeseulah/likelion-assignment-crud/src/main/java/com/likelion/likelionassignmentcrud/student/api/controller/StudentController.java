package com.likelion.likelionassignmentcrud.student.api.controller;

import com.likelion.likelionassignmentcrud.student.api.dto.request.StudentRequestDto;
import com.likelion.likelionassignmentcrud.student.api.dto.response.StudentResponseDto;
import com.likelion.likelionassignmentcrud.student.application.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Long createStudent(@RequestBody StudentRequestDto requestDto) {
        return studentService.createStudent(requestDto);
    }

    @GetMapping
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
