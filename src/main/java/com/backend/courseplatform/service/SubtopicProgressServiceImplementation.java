package com.backend.courseplatform.service;


import com.backend.courseplatform.entity.Course;
import com.backend.courseplatform.entity.SubTopicProgress;
import com.backend.courseplatform.entity.Subtopics;
import com.backend.courseplatform.entity.User;
import com.backend.courseplatform.repository.EnrollmentRepository;
import com.backend.courseplatform.repository.SubtopicProgressRepository;
import com.backend.courseplatform.repository.SubtopicsRepository;
import com.backend.courseplatform.repository.UserRepository;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
public class SubtopicProgressServiceImplementation implements SubtopicProgressService {
    private final UserRepository userRepository;
    private final SubtopicsRepository subtopicsRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final SubtopicProgressRepository subtopicProgressRepository;

    @Override
    public void completeSubtopic(String subtopicId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user=userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Subtopics subtopic=subtopicsRepository.findById(subtopicId)
                .orElseThrow(() -> new IllegalArgumentException("Subtopic not found"));

        Course course=subtopic.getTopic().getCourse();
        enrollmentRepository.findByUser_IdAndCourse_Id(user.getId(), course.getId())
                .orElseThrow(() -> new IllegalStateException("User not enrolled"));

        if(subtopicProgressRepository
                .findByUser_IdAndSubtopic_Id(user.getId(), subtopicId)
                .isPresent()){
            return;
        }
        SubTopicProgress progress = new SubTopicProgress();
        progress.setUser(user);
        progress.setSubtopic(subtopic);
        progress.setCompleted(true);
        progress.setCompletedAt(LocalDateTime.now());

        subtopicProgressRepository.save(progress);
    }
}
