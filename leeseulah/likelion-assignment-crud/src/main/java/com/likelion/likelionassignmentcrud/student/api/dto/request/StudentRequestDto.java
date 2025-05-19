package com.likelion.likelionassignmentcrud.student.api.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentRequestDto {
    private String name;
    private String email;
    private Long lectureId;
}
