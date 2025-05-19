package com.likelion.likelionassignmentcrud.student.api.dto.response;

import com.likelion.likelionassignmentcrud.student.domain.model.Student;
import lombok.Getter;

@Getter
public class StudentResponseDto {
    private Long id;
    private String name;
    private String email;
    private Long lectureId;

    public StudentResponseDto(Long id, String name, String email, Long lectureId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.lectureId = lectureId;
    }

    public static StudentResponseDto fromEntity(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getLecture().getId()
        );
    }
}
