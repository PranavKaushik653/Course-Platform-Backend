package com.backend.courseplatform.service;

import com.backend.courseplatform.dto.ProgressResponseDTO;
import com.backend.courseplatform.entity.Course;
import com.backend.courseplatform.entity.User;
import com.backend.courseplatform.repository.*;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Data
public class ProgressServiceImplementation implements ProgressService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final SubtopicsRepository subtopicRepository;
    private final SubtopicProgressRepository subtopicProgressRepository;

    @Override
    public ProgressResponseDTO getProgressResponseDTO(String courseId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email= authentication.getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("User not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new IllegalArgumentException("Course not found"));
        enrollmentRepository.findByUser_IdAndCourse_Id(user.getId(), course.getId())
                .orElseThrow(()-> new IllegalStateException("User not enrolled"));

        long totalSubtopics=subtopicRepository.countByTopic_Course_Id(courseId);
        long completedSubtopics =
                subtopicProgressRepository
                        .countByUser_IdAndSubtopic_Topic_Course_IdAndCompleted(
                                user.getId(),
                                courseId,
                                true
                        );
        double percentage = totalSubtopics == 0
                ? 0.0
                : (completedSubtopics * 100.0) / totalSubtopics;

        return new ProgressResponseDTO(
                totalSubtopics,
                completedSubtopics,
                Math.round(percentage * 100.0) / 100.0
        );
    }
}
