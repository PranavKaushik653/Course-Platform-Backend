package com.backend.courseplatform.controller;

import com.backend.courseplatform.service.EnrollmentServiceImplementation;
import com.backend.courseplatform.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/{courseId}/enroll")
    public ResponseEntity<Map<String, String>> enroll(
            @PathVariable String courseId
    ) {
        enrollmentService.enroll(courseId);
        return ResponseEntity.ok(
                Map.of("message", "Enrolled successfully")
        );
    }
}
