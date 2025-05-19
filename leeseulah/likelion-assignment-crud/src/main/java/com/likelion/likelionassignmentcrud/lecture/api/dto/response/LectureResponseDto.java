package com.likelion.likelionassignmentcrud.lecture.api.dto.response;

import com.likelion.likelionassignmentcrud.lecture.domain.model.Lecture;
import lombok.Getter;

@Getter
public class LectureResponseDto {
    private Long id;
    private String title;
    private String instructor;

    public LectureResponseDto(Long id, String title, String instructor) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
    }

    public static LectureResponseDto fromEntity(Lecture lecture) {
        return new LectureResponseDto(
                lecture.getId(),
                lecture.getTitle(),
                lecture.getInstructor()
        );
    }
}
