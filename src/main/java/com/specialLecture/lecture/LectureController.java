package com.specialLecture.lecture;

import com.specialLecture.dto.UserLectureResponseDto;
import com.specialLecture.entity.UserLecture;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/lectures")
@RestController
public class LectureController {
    private final LectureService lectureService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/{user_id}/registrations/{lecture_id}")
    public ResponseEntity<UserLectureResponseDto> register(
            @PathVariable long userId,
            @PathVariable long lectureId
    ) {
        return ResponseEntity.ok().body(
            lectureService.register(userId, lectureId)
        );
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{user_id}/registrations/{lecture_id}")
    public ResponseEntity<Boolean> getRegisterStatus(
            @PathVariable Long userId,
            @PathVariable Long lectureId
    ) {
        return ResponseEntity.ok().body(
            lectureService.getRegisterStatus(userId, lectureId)
        );
    }
}
