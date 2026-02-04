package com.backend.courseplatform.service;

import com.backend.courseplatform.entity.Course;
import com.backend.courseplatform.entity.Enrollment;
import com.backend.courseplatform.entity.User;
import com.backend.courseplatform.repository.CourseRepository;
import com.backend.courseplatform.repository.EnrollmentRepository;
import com.backend.courseplatform.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
//@AllArgsConstructor
public class EnrollmentServiceImplementation implements EnrollmentServcie{
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    @Override
    public void enroll(String courseId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email=authentication.getName();

        User user=userRepository.findByEmail(email)
        .orElseThrow(()->new IllegalArgumentException("User not found"));

        Course course=courseRepository.findById(courseId)
                .orElseThrow(()->new IllegalArgumentException("Course not found"));

        boolean alreadEnrolled=enrollmentRepository.existsByUser_IdAndCourse_Id(user.getId(), courseId);

        if(alreadEnrolled){
            throw new IllegalStateException("User already enrolled");
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setUser(user);
        enrollment.setCourse(course);
        enrollment.setEnrolledAt(LocalDateTime.now());

        enrollmentRepository.save(enrollment);
    }
}
