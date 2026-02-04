package com.backend.courseplatform.controller;

import com.backend.courseplatform.service.EnrollmentServcie;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/courses")
public class EnrollmentController {

    private final EnrollmentServcie enrollmentServcie;

    @PostMapping
    public ResponseEntity<?> enroll(@PathVariable String courseId){
        enrollmentServcie.enroll(courseId);
        return ResponseEntity.ok(java.util.Map.of("message","Enrolled successfully")
        );
    }
}
