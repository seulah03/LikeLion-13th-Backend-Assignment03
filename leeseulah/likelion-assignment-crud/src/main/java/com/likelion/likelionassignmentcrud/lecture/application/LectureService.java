package com.likelion.likelionassignmentcrud.lecture.application;

import com.likelion.likelionassignmentcrud.lecture.api.dto.request.LectureRequestDto;
import com.likelion.likelionassignmentcrud.lecture.api.dto.response.LectureResponseDto;
import com.likelion.likelionassignmentcrud.lecture.domain.model.Lecture;
import com.likelion.likelionassignmentcrud.lecture.domain.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;

    public Long createLecture(LectureRequestDto requestDto) {
        Lecture lecture = new Lecture(requestDto.getTitle(), requestDto.getInstructor());
        return lectureRepository.save(lecture).getId();
    }

    public List<LectureResponseDto> getAllLectures() {
        return lectureRepository.findAll().stream()
                .map(LectureResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public LectureResponseDto getLecture(Long id) {
        Lecture lecture = lectureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 강의가 존재하지 않습니다."));
        return LectureResponseDto.fromEntity(lecture);
    }

    public void deleteLecture(Long id) {
        lectureRepository.deleteById(id);
    }
}
